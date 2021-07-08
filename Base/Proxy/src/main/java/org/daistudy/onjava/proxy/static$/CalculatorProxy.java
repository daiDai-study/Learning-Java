package org.daistudy.onjava.proxy.static$;

import org.daistudy.onjava.proxy.model.Calculator;

/**
 * 静态代理只能为一种目标对象服务
 * 动态代理可以为任意多个目标对象服务
 */
public class CalculatorProxy implements Calculator {

    private Calculator target;

    public CalculatorProxy(Calculator target){
        this.target = target;
    }

    @Override
    public int add(int a, int b) {
        System.out.println("静态代理对象代理目标对象开始");
        int result = this.target.add(a, b);
        System.out.println("静态代理对象代理目标对象结束");
        return result;
    }
}
