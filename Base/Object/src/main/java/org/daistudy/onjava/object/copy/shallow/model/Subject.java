package org.daistudy.onjava.object.copy.shallow.model;

/**
 * @Author 60056306
 * @Date 2020/6/18 10:50
 * @Version 1.0
 **/
public class Subject implements Cloneable {

    private String name;
    private int height;
    private Integer weight;

    public Subject(String name, int height, Integer weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String s) {
        name = s;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
