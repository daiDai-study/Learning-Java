package org.daistudy.web.mvc.framework;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// 为了简化处理，只支持JSON格式的POST请求
public class PostDispatcher implements Dispatcher {
    private Object instance; // Controller 实例
    private Method method; // Controller 方法
    private Class<?>[] parameterClasses; // 方法参数类型
    private ObjectMapper objectMapper; // JSON映射

    public PostDispatcher(Object instance, Method method, Class<?>[] parameterClasses, ObjectMapper objectMapper) {
        this.instance = instance;
        this.method = method;
        this.parameterClasses = parameterClasses;
        this.objectMapper = objectMapper;
    }

    @Override
    public ModelAndView invoke(HttpServletRequest req, HttpServletResponse resp) throws InvocationTargetException, IllegalAccessException, IOException {
        final Object[] arguments = new Object[parameterClasses.length];
        for (int i = 0; i < parameterClasses.length; i++) {
            final Class<?> parameterClass = parameterClasses[i];
            if(parameterClass == HttpServletRequest.class){
                arguments[i] = req;
            }else if (parameterClass == HttpServletResponse.class){
                arguments[i] = resp;
            }else if (parameterClass == HttpSession.class){
                arguments[i] = req.getSession();
            } else {
                // 读取JSON并解析为JavaBean:
                BufferedReader reader = req.getReader();
                arguments[i] = this.objectMapper.readValue(reader, parameterClass);
            }
        }
        return ((ModelAndView) this.method.invoke(instance, arguments));
    }
}
