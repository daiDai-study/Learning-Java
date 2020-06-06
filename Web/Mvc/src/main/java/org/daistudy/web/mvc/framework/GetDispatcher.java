package org.daistudy.web.mvc.framework;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

public class GetDispatcher implements Dispatcher {
    private Object instance; // Controller 实例
    private Method method; // Controller 方法
    private String[] parameterNames; // 方法参数名称
    private Class<?>[] parameterClasses; // 方法参数类型

    public GetDispatcher(Object instance, Method method, String[] parameterNames, Class<?>[] parameterClasses) {
        this.instance = instance;
        this.method = method;
        this.parameterNames = parameterNames;
        this.parameterClasses = parameterClasses;
    }

    @Override
    public ModelAndView invoke(HttpServletRequest req, HttpServletResponse resp) throws InvocationTargetException, IllegalAccessException, IOException {
        final Object[] arguments = new Object[parameterClasses.length];
        for (int i = 0; i < parameterClasses.length; i++) {
            final String parameterName = parameterNames[i];
            final Class<?> parameterClass = parameterClasses[i];
            if(parameterClass == HttpServletRequest.class){
                arguments[i] = req;
            }else if (parameterClass == HttpServletResponse.class){
                arguments[i] = resp;
            }else if (parameterClass == HttpSession.class){
                arguments[i] = req.getSession();
            } else if (parameterClass == int.class) {
                arguments[i] = Integer.valueOf(getOrDefault(req, parameterName, "0"));
            } else if (parameterClass == long.class) {
                arguments[i] = Long.valueOf(getOrDefault(req, parameterName, "0"));
            } else if (parameterClass == boolean.class) {
                arguments[i] = Boolean.valueOf(getOrDefault(req, parameterName, "false"));
            } else if (parameterClass == String.class) {
                arguments[i] = getOrDefault(req, parameterName, "");
            } else {
                throw new RuntimeException("Missing handler for type: " + parameterClass);
            }
        }
        return ((ModelAndView) this.method.invoke(instance, arguments));
    }

    private String getOrDefault(HttpServletRequest request, String name, String defaultValue) {
        String s = request.getParameter(name);
        return s == null ? defaultValue : s;
    }
}
