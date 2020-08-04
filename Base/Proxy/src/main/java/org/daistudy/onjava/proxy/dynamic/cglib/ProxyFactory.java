package org.daistudy.onjava.proxy.dynamic.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib 动态代理的目标对象无需实现接口，可以达到代理类无侵入
 * cglib 动态代理通过生成类字节码实现代理
 */
public class ProxyFactory implements MethodInterceptor {
    private Object target;

    public ProxyFactory(Object target){
        this.target = target;
    }

    // 为目标对象生成代理对象
    public Object getProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib 动态代理开始");
        // 执行目标对象的方法
        Object returnValue = method.invoke(target, args);
        System.out.println("cglib 动态代理结束");
        return null;
    }
}
