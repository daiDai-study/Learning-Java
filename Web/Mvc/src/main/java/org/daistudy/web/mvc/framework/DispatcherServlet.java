package org.daistudy.web.mvc.framework;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.geometry.Pos;
import org.daistudy.web.mvc.controller.IndexController;
import org.daistudy.web.mvc.controller.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;

@WebServlet(urlPatterns = "/")
public class DispatcherServlet extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private Map<String, GetDispatcher> getMappings = new HashMap<>();
    private Map<String, PostDispatcher> postMappings = new HashMap<>();
    private ViewEngine viewEngine;

    // 可指定package并自动扫描:
    private List<Class<?>> controllers = Arrays.asList(IndexController.class, UserController.class);

    @Override
    public void init() throws ServletException {
        // 扫描 controllers 设置 getMappings 和 postMappings
        logger.info("init {}...", getClass().getSimpleName());
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        for (Class<?> controller : controllers) {
            try{
                final Object controllerInstance = controller.getConstructor().newInstance();
                // 处理 controller 中的 method
                for (Method method : controller.getMethods()) {
                    if(method.getAnnotation(GetMapping.class) != null){
                        if(method.getReturnType() != ModelAndView.class && method.getReturnType() != void.class){
                            throw new UnsupportedOperationException("Unsupported return type: " + method.getReturnType() + " for method: " + method);
                        }
                        for (Class<?> parameterType : method.getParameterTypes()) {
                            if(!supportedGetParameterTypes.contains(parameterType)){
                                throw new UnsupportedOperationException("Unsupported parameter type: " + parameterType + " for method: " + method);
                            }
                        }
                        final String[] parameterNames = Arrays.stream(method.getParameters()).map(Parameter::getName).toArray(String[]::new);
                        final String path = method.getAnnotation(GetMapping.class).value();
                        logger.info("Found GET: {} => {}", path, method);
                        this.getMappings.put(path, new GetDispatcher(controllerInstance, method, parameterNames, method.getParameterTypes()));
                    }else if(method.getAnnotation(PostMapping.class) != null){
                        if(method.getReturnType() != ModelAndView.class && method.getReturnType() != void.class){
                            throw new UnsupportedOperationException("Unsupported return type: " + method.getReturnType() + " for method: " + method);
                        }
                        Class<?> requestBodyClass = null;
                        for (Class<?> parameterType : method.getParameterTypes()) {
                            if(!supportedPostParameterTypes.contains(parameterType)){
                                if(requestBodyClass == null){
                                    requestBodyClass = parameterType;
                                }else{
                                    throw new UnsupportedOperationException("Unsupported duplicate request body type: " + parameterType + " for method: " + method);
                                }
                            }
                        }
                        final String path = method.getAnnotation(PostMapping.class).value();
                        logger.info("Found POST: {} => {}", path, method);
                        this.postMappings.put(path, new PostDispatcher(controllerInstance, method, method.getParameterTypes(), objectMapper));
                    }
                }
            }
            catch(ReflectiveOperationException e){
                throw new ServletException(e);
            }
        }

        this.viewEngine = new ViewEngine(getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doExecute(req, resp, this.getMappings);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doExecute(req, resp, this.postMappings);
    }

    private void doExecute(HttpServletRequest req, HttpServletResponse resp, Map<String, ? extends Dispatcher> dispatcherMap) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        // 根据请求路径找到对应的执行方法
        final String path = req.getRequestURI().substring(req.getContextPath().length());
        final Dispatcher dispatcher = dispatcherMap.get(path);

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

    private static final Set<Class<?>> supportedGetParameterTypes = new HashSet<>(Arrays.asList(int.class, long.class, boolean.class,
            String.class, HttpServletRequest.class, HttpServletResponse.class, HttpSession.class));

    private static final Set<Class<?>> supportedPostParameterTypes = new HashSet<>(Arrays.asList(HttpServletRequest.class,
            HttpServletResponse.class, HttpSession.class));
}
