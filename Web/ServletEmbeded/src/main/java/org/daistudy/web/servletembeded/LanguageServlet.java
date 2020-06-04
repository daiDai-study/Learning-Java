package org.daistudy.web.servletembeded;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@WebServlet(urlPatterns = "/pref")
public class LanguageServlet extends HttpServlet {
    private static final Set<String>  LANGUAGES = new HashSet<>(Arrays.asList("en", "zh"));

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String lang = req.getParameter("lang");
        if(LANGUAGES.contains(lang)){
            // 创建一个新的 Cookie
            final Cookie cookie = new Cookie("lang", lang);
            // 该 Cookie 生效的路径范围
            cookie.setPath("/");
            // 该 Cookie 的有效期
//            cookie.setMaxAge(864000); // 864000秒=10天
            // 添加到响应中
            resp.addCookie(cookie);
        }
        resp.sendRedirect("/");
    }
}
