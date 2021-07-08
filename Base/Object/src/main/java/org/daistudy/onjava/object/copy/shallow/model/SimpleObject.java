package org.daistudy.onjava.object.copy.shallow.model;

public class SimpleObject {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public SimpleObject(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "SimpleObject{" +
            "name='" + name + '\'' +
            ", age=" + age +
            '}';
    }
}
