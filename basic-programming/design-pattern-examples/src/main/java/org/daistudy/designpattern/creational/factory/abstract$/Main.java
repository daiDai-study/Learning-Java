package org.daistudy.designpattern.creational.factory.abstract$;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Factory factory = new ConcreteFactory1();
        ProductA productA = factory.createProductA();
        productA.use();
        ProductB productB = factory.createProductB();
        productB.eat();

        factory = new ConcreteFactory2();
        productA = factory.createProductA();
        productA.use();
        productB = factory.createProductB();
        productB.eat();
    }
}
