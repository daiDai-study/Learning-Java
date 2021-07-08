package org.daistudy.designpattern.creational.factory.method;

public class ConcreteFactoryB implements Factory {
    @Override
    public Product createProduct() {
        return new ConcreteProductB();
    }
}
