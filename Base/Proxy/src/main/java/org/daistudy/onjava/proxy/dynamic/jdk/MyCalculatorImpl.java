package org.daistudy.onjava.proxy.dynamic.jdk;

public class MyCalculatorImpl implements MyCalculator {
    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
