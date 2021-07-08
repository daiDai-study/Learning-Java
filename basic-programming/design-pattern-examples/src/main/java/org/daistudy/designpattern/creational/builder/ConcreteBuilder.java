package org.daistudy.designpattern.creational.builder;

public class ConcreteBuilder extends Builder {
    public ConcreteBuilder(){
        product = new Product();
    }

    @Override
    public void buildPartA() {
        product.setPartA("A Style");
    }

    @Override
    public void buildPartB() {
        product.setPartB("B Style");
    }

    @Override
    public void buildPartC() {
        product.setPartC("C Style");
    }

    @Override
    public Product getProduct() {
        return product;
    }
}
