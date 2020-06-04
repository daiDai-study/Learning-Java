package org.daistudy.web.hellomvc.servlet;

import org.daistudy.web.hellomvc.model.School;
import org.daistudy.web.hellomvc.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 假装从数据库读取:
        School school = new School("No.1 Middle School", "101 South Street");
        User user = new User(123L, "Bob", school);
        // 放入Request中:
        req.setAttribute("user", user);
        // 转发给 user.jsp
        // 把user.jsp放到/WEB-INF/目录下，是因为WEB-INF是一个特殊目录
        // Web Server会阻止浏览器对WEB-INF目录下任何资源的访问，这样就防止用户通过/user.jsp路径直接访问到JSP页面；
        req.getRequestDispatcher("/WEB-INF/user.jsp").forward(req, resp);
    }
}
