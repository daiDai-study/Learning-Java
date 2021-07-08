package org.daistudy.onjava.proxy.dynamic.cglib;


import org.daistudy.onjava.proxy.model.CalculatorCglib;

public class Main {
    public static void main(String[] args) {
        CalculatorCglib target = new CalculatorCglib();
        System.out.println(target.getClass());  //输出目标对象信息
        ProxyFactory proxyFactory = new ProxyFactory(target);
        CalculatorCglib proxy = (CalculatorCglib) proxyFactory.getProxy();
        System.out.println(proxy.getClass());  //输出代理对象信息
        final int add = proxy.add(1, 2);
        System.out.println("result:"+ add);
    }
}
