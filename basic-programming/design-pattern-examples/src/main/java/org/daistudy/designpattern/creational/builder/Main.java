package org.daistudy.designpattern.creational.builder;

public class Main {
    public static void main(String[] args) {
        System.out.println("CreationalPatterns/BuilderPattern");
        Director director = new Director();
        ConcreteBuilder builder = new ConcreteBuilder();
        director.setBuilder(builder);
        Product product = director.constuct();
        System.out.println(product.toString());
    }
}
