package org.daistudy.onjava.proxy.dynamic.jdk;

public class Main {
    public static void main(String[] args) {
        final MyCalculator instance = (MyCalculator)MyCalculatorProxy.getInstance(new MyCalculatorImpl());
        System.out.println("instance"+instance);
        final int add = instance.add(1, 2);
        System.out.println("result:"+ add);
    }
}
