package org.daistudy.onjava.proxy.dynamic.jdk;

import org.daistudy.onjava.proxy.model.Calculator;
import org.daistudy.onjava.proxy.model.CalculatorImpl;

public class Main {
    public static void main(String[] args) {
        Calculator target = new CalculatorImpl();
        System.out.println(target.getClass());  //输出目标对象信息
        ProxyFactory proxyFactory = new ProxyFactory(target);
        Calculator proxy = (Calculator) proxyFactory.getProxyInstance();
        System.out.println(proxy.getClass());  //输出代理对象信息
        final int add = proxy.add(1, 2);
        System.out.println("result:"+ add);
    }
}
