package org.daistudy.onjava.collections.entity.pets;

public class Person {
    private String name;
    public Person(){}
    public Person(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
