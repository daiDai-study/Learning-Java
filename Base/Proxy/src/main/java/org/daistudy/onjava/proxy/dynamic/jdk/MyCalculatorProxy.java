package org.daistudy.onjava.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyCalculatorProxy {
    public static Object getInstance(final MyCalculator myCalculator){
        return Proxy.newProxyInstance(myCalculator.getClass().getClassLoader(), myCalculator.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                final String methodName = method.getName();
                System.out.println(methodName + "方法开始执行...");
                Object invoke;
                try {
                    invoke = method.invoke(myCalculator, args);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new Exception(e);
                }
                System.out.println(methodName + "方法执行结束...");
                return invoke;
            }
        });
    }
}
