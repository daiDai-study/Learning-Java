package org.daistudy.web.mvc.framework;

import org.daistudy.web.mvc.controller.IndexController;
import org.daistudy.web.mvc.controller.UserController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/")
public class DispatcherServlet extends HttpServlet {
    private Map<String, GetDispatcher> getMappings = new HashMap<>();
    private Map<String, PostDispatcher> postMappings = new HashMap<>();
    private ViewEngine viewEngine;

    // TODO: 可指定package并自动扫描:
    private List<Class<?>> controllers = Arrays.asList(IndexController.class, UserController.class);

    @Override
    public void init() throws ServletException {
        // TODO：扫描 controllers 设置 getMappings 和 postMappings
        this.viewEngine = new ViewEngine(getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        // 根据请求路径找到对应的执行方法
        final String path = req.getRequestURI().substring(req.getContextPath().length());
        final GetDispatcher dispatcher = this.getMappings.get(path);

        // 调用执行方法后获得结果
        if(dispatcher == null){
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        ModelAndView mv = null;
        try {
            mv = dispatcher.invoke(req, resp);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // 将结果给模板进行渲染
        if(mv == null){
            return;
        }
        if(mv.getView() != null && mv.getView().startsWith("redirect:")){
            resp.sendRedirect(mv.getView().substring("redirect:".length()));
            return;
        }

        // 写到响应中
        final PrintWriter pw = resp.getWriter();
        this.viewEngine.render(mv, pw);
        pw.flush();
    }
}
