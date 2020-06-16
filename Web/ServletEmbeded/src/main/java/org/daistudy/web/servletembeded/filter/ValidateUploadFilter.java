package org.daistudy.web.servletembeded.filter;

import org.daistudy.web.servletembeded.servlet.repeatread.ReReadableHttpServletRequest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigInteger;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@WebFilter(urlPatterns = "/upload/*")
public class ValidateUploadFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 获取客户端传入的签名方法和签名:
        final String digest = request.getHeader("Signature-Method");
        final String signature = request.getHeader("Signature");
        if(digest == null || digest.isEmpty() || signature == null || signature.isEmpty()){
            sendErrorPage(response, "Missing signature");
            return;
        }

        // 读取Request的Body并验证签名:
        final MessageDigest messageDigest = getMessageDigest(digest);
        try (DigestInputStream input = new DigestInputStream(request.getInputStream(), messageDigest)) {
            try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
                int n;
                byte[] buffer = new byte[1024];
                while ((n = input.read(buffer)) != -1) {
                    output.write(buffer, 0, n);
                }

                final String actual= toHexString(messageDigest.digest());
                // TODO 验证总是失败，需要了解加密相关概念和基础应用后再真正实现
//                if (!signature.equals(actual)) {
//                    sendErrorPage(response, "Invalid signature.");
//                    return;
//                }
                // 验证成功后继续处理:
                final ReReadableHttpServletRequest reReadRequest1 = new ReReadableHttpServletRequest(request, output.toByteArray());
                final ReReadableHttpServletRequest reReadRequest2 = new ReReadableHttpServletRequest(request, output.toByteArray());
                final ReReadableHttpServletRequest reReadRequest3 = new ReReadableHttpServletRequest(request, output.toByteArray());
                final ReReadableHttpServletRequest reReadRequest4 = new ReReadableHttpServletRequest(request, output.toByteArray());
                final BufferedReader reader = reReadRequest4.getReader();
                final String md5HashCode = md5HashCode(reReadRequest1.getInputStream());
                final String md5HashCode32 = md5HashCode32(reReadRequest2.getInputStream());
                filterChain.doFilter(reReadRequest3, servletResponse);
            }
        }
//        filterChain.doFilter(servletRequest, servletResponse);
    }

    // 将byte[]转换为hex string:
    private String toHexString(byte[] digest) {
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    private MessageDigest getMessageDigest(String name) throws ServletException {
        try {
            return MessageDigest.getInstance(name);
        } catch (NoSuchAlgorithmException e) {
            throw new ServletException(e);
        }
    }

    private void sendErrorPage(HttpServletResponse response, String errorMessage) throws IOException {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        final PrintWriter pw = response.getWriter();
        pw.write("<html><body><h1>");
        pw.write(errorMessage);
        pw.write("</h1></body></html>");
        pw.flush();
    }

    /**
     * java获取文件的md5值
     * @param fis 输入流
     * @return
     */
    public static String md5HashCode(InputStream fis) {
        try {
            //拿到一个MD5转换器,如果想使用SHA-1或SHA-256，则传入SHA-1,SHA-256
            MessageDigest md = MessageDigest.getInstance("MD5");

            //分多次将一个文件读入，对于大型文件而言，比较推荐这种方式，占用内存比较少。
            byte[] buffer = new byte[1024];
            int length = -1;
            while ((length = fis.read(buffer, 0, 1024)) != -1) {
                md.update(buffer, 0, length);
            }
            fis.close();
            //转换并返回包含16个元素字节数组,返回数值范围为-128到127
            byte[] md5Bytes  = md.digest();
            BigInteger bigInt = new BigInteger(1, md5Bytes);//1代表绝对值
            return bigInt.toString(16);//转换为16进制
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * java计算文件32位md5值
     * @param fis 输入流
     * @return
     */
    public static String md5HashCode32(InputStream fis) {
        try {
            //拿到一个MD5转换器,如果想使用SHA-1或SHA-256，则传入SHA-1,SHA-256
            MessageDigest md = MessageDigest.getInstance("MD5");

            //分多次将一个文件读入，对于大型文件而言，比较推荐这种方式，占用内存比较少。
            byte[] buffer = new byte[1024];
            int length = -1;
            while ((length = fis.read(buffer, 0, 1024)) != -1) {
                md.update(buffer, 0, length);
            }
            fis.close();

            //转换并返回包含16个元素字节数组,返回数值范围为-128到127
            byte[] md5Bytes  = md.digest();
            StringBuffer hexValue = new StringBuffer();
            for (int i = 0; i < md5Bytes.length; i++) {
                int val = ((int) md5Bytes[i]) & 0xff;//解释参见最下方
                if (val < 16) {
                    /**
                     * 如果小于16，那么val值的16进制形式必然为一位，
                     * 因为十进制0,1...9,10,11,12,13,14,15 对应的 16进制为 0,1...9,a,b,c,d,e,f;
                     * 此处高位补0。
                     */
                    hexValue.append("0");
                }
                //这里借助了Integer类的方法实现16进制的转换
                hexValue.append(Integer.toHexString(val));
            }
            return hexValue.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}


