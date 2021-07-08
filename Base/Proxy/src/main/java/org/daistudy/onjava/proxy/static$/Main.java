package org.daistudy.onjava.proxy.static$;

import org.daistudy.onjava.proxy.model.CalculatorImpl;

public class Main {
    public static void main(String[] args) {
        CalculatorImpl target = new CalculatorImpl();
        CalculatorProxy proxy = new CalculatorProxy(target);
        System.out.println(proxy.add(1, 2));
    }
}
