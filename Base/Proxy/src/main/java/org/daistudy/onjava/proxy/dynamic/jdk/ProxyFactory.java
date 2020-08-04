package org.daistudy.onjava.proxy.dynamic.jdk;

import org.daistudy.onjava.proxy.model.Calculator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理的目标对象必须实现一个或多个接口
 * 代理类中: 实现InvocationHandler接口
 * JDK动态代理通过反射实现代理
 */
public class ProxyFactory {

    private Object target;

    public ProxyFactory(Object target){
        this.target = target;
    }

    public Object getProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                final String methodName = method.getName();
                System.out.println("JDK动态代理：" + methodName + "方法开始执行...");
                Object invoke;
                try {
                    invoke = method.invoke(target, args);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new Exception(e);
                }
                System.out.println("JDK动态代理：" + methodName + "方法执行结束...");
                return invoke;
            }
        });
    }
}
