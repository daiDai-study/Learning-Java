package org.daistudy.web.mvc.controller;

import org.daistudy.web.mvc.bean.SignInBean;
import org.daistudy.web.mvc.bean.User;
import org.daistudy.web.mvc.framework.GetMapping;
import org.daistudy.web.mvc.framework.ModelAndView;
import org.daistudy.web.mvc.framework.PostMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class UserController {

    private Map<String, User> userDatabase = new HashMap<>();

    {
        List<User> users = new ArrayList<>(Arrays.asList(new User("bob@example.com", "bob123", "Bob", "This is bob."),
                new User("tom@example.com", "tomcat", "Tom", "This is tom."))
        );
        users.stream().forEach(user -> userDatabase.put(user.getEmail(), user));
    }

    @GetMapping("/signin")
    public ModelAndView signin() {
        return new ModelAndView("/signin.html");
    }

    @PostMapping("/signin")
    public ModelAndView doSignin(SignInBean bean, HttpServletResponse response, HttpSession session)
            throws IOException {
        User user = userDatabase.get(bean.getEmail());
        if (user == null || !user.getPassword().equals(bean.getPassword())) {
            response.setContentType("application/json");
            PrintWriter pw = response.getWriter();
            pw.write("{\"error\":\"Bad email or password\"}");
            pw.flush();
        } else {
            session.setAttribute("user", user);
            response.setContentType("application/json");
            PrintWriter pw = response.getWriter();
            pw.write("{\"result\":true}");
            pw.flush();
        }
        return null;
    }

    @GetMapping("/signout")
    public ModelAndView signout(HttpSession session) {
        session.removeAttribute("user");
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/user/profile")
    public ModelAndView profile(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return new ModelAndView("redirect:/signin");
        }
        return new ModelAndView("/profile.html", "user", user);
    }
}
