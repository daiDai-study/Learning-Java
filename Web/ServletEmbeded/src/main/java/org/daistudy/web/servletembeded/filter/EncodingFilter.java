package org.daistudy.web.servletembeded.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class EncodingFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) request;
//        String path = req.getRequestURI().substring(req.getContextPath().length());
//        System.out.println("---------" + path + ": EncodingFilter:doFilter");
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);
    }
}
