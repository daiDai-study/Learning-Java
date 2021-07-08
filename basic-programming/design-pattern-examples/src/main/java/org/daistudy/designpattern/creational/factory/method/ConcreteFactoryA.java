package org.daistudy.designpattern.creational.factory.method;

public class ConcreteFactoryA implements Factory {
    @Override
    public Product createProduct() {
        return new ConcreteProductA();
    }
}
