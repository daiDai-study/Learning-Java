package org.daistudy.designpattern.creational.factory.method;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Factory factory = new ConcreteFactoryA();
        Product p = factory.createProduct();
        p.use();

        factory = new ConcreteFactoryB();
        p = factory.createProduct();
        p.use();
    }
}
