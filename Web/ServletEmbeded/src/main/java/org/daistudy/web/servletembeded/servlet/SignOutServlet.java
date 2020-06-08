package org.daistudy.web.servletembeded.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

@WebServlet(urlPatterns = "/signout")
public class SignOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 从 HttpSession 移除用户名
        req.getSession().removeAttribute("user");
        resp.sendRedirect("/");
    }
}
