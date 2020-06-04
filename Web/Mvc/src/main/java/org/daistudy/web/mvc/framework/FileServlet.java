package org.daistudy.web.mvc.framework;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@WebServlet(urlPatterns = {"/favicon.ico", "/static/*"})
public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final ServletContext servletContext = req.getServletContext();
        // 读取当前请求路径:
        final String urlPath = req.getRequestURI().substring(req.getContextPath().length());
        // 获取真实文件路径:
        final String filePath = servletContext.getRealPath(urlPath);
        if(filePath == null){
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        final Path path = Paths.get(filePath);
        if(!path.toFile().isFile()){
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        // 根据文件名猜测 Content-Type
        String mime = Files.probeContentType(path);
        if(mime == null){
            mime = "application/octet-stream";
        }
        resp.setContentType(mime);
        // 读取文件并写入Response:
        final ServletOutputStream output = resp.getOutputStream();
        try(final InputStream input = new BufferedInputStream(new FileInputStream(filePath))){
            byte[] buffer = new byte[1024];
            int n;
            while ((n = input.read()) != -1) { // 利用while同时读取并判断
                output.write(n);
            }
        }
        output.flush();
    }
}
