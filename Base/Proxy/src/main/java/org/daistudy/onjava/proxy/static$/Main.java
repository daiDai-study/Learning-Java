package org.daistudy.onjava.proxy.static$;

import org.daistudy.onjava.proxy.model.CalculatorImpl;

public class Main {
    public static void main(String[] args) {
        System.out.println(new ProxyFactory(new CalculatorImpl()).add(1, 2));
    }
}
