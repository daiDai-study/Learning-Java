package org.daistudy.designpattern.creational.factory.abstract$;

public class ConcreteFactory2 implements Factory {
    @Override
    public ProductA createProductA() {
        return new ConcreteProductA2();
    }

    @Override
    public ProductB createProductB() {
        return new ConcreteProductB2();
    }
}
