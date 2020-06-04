package org.daistudy.web.servletembeded;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/signin")
public class SignInServlet extends HttpServlet {
    // 模拟用户列表（数据库）
    private  Map<String, String> users = new HashMap<>();

    {
        users.put("bob", "bob123");
        users.put("alice", "alice123");
        users.put("tom", "tomcat");
    }

    // GET 请求时显示登录页
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        final PrintWriter pw = resp.getWriter();
        pw.write("<h1>Sign In</h1>");
        pw.write("<form action=\"/signin\" method=\"post\">");
        pw.write("<p>Username: <input name=\"username\"></p>");
        pw.write("<p>Password: <input name=\"password\" type=\"password\"></p>");
        pw.write("<p><button type=\"submit\">Sign In</button> <a href=\"/\">Cancel</a></p>");
        pw.write("</form>");
        pw.flush();
    }

    // POST 请求时处理用户登录

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String username = req.getParameter("username");
        final String password = req.getParameter("password");
        final String expectedPassword = users.get(username);
        if(expectedPassword != null && expectedPassword.equals(password)){
            // 登录成功
            req.getSession().setAttribute("user", username);
            resp.sendRedirect("/");
        }else{
            resp.sendError(HttpServletResponse.SC_FORBIDDEN);
        }
    }
}
