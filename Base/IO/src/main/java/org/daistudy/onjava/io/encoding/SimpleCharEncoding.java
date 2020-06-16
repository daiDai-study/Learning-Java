package org.daistudy.onjava.io.encoding;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleCharEncoding {
    public static void main(String[] args) throws UnsupportedEncodingException {
        // char类型实际上就是两个字节的Unicode编码
        String str = "Hi 中文";
        String b1 = bytesToHex(str.getBytes()); // 按系统默认编码转换，不推荐
        String b2 = bytesToHex(str.getBytes("UTF-8")); // 按UTF-8编码转换
        // GB2312标准使用两个字节表示一个汉字，其中第一个字节的最高位始终为1
        String b3 = bytesToHex(str.getBytes("GBK")); // 按GBK编码转换
        String b4 = bytesToHex(str.getBytes(StandardCharsets.UTF_8)); // 按UTF-8编码转换
        String b5 = bytesToHex(str.getBytes(StandardCharsets.UTF_16)); // 按UTF-8编码转换
        System.out.println("b1: " + b1);
        System.out.println("b2: " + b2);
        System.out.println("b3: " + b3);
        System.out.println("b4: " + b4);
        System.out.println("b5: " + b5);

//        byte[] bytes = {hexToByte("0xfe"), hexToByte("0xff")};
//        String s1 = new String(bytes, "GBK"); // 按GBK转换
//        String s2 = new String(bytes, StandardCharsets.UTF_8); // 按UTF-8转换
//        System.out.println(s1);
//        System.out.println(s2);

        char a = '\u0000';
        System.out.println("'\\u0000' ==> " + a);
        System.out.println("int('\\u0000') ==> " + (int) a);

    }

    private static byte hexToByte(String inHex){
        return (byte)Integer.parseInt(inHex,16);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if(hex.length() < 2){
                sb.append(0);
            }
            sb.append("0x").append(hex).append(" ");
        }
        return sb.toString();
    }
}
