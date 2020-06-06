package org.daistudy.web.mvc.controller;

import org.daistudy.web.mvc.bean.User;
import org.daistudy.web.mvc.framework.GetMapping;
import org.daistudy.web.mvc.framework.ModelAndView;

import javax.servlet.http.HttpSession;

public class IndexController {
    @GetMapping("/")
    public ModelAndView index(HttpSession session){
        User user = (User) session.getAttribute("user");
        return new ModelAndView("/index.html", "user", user);
    }

    @GetMapping("/hello")
    public ModelAndView hello(String name){
        if(name == null || name.equals("")){
            name = "World";
        }
        return new ModelAndView("/hello.html", "name", name);
    }
}
