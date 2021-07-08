package org.daistudy.onjava.object.copy.shallow.main;

public class SimpleObjectWithoutCloneable {

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "SimpleObjectWithoutCloneable{" +
            "age=" + age +
            '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        SimpleObjectWithoutCloneable obj = new SimpleObjectWithoutCloneable();
        obj.setAge(1);
        SimpleObjectWithoutCloneable clone = (SimpleObjectWithoutCloneable)obj.clone();
        clone.setAge(2);
        System.out.println("obj == clone :" + (obj == clone));
        System.out.println("obj.equals(clone) :" + (obj.equals(clone)));
        System.out.println("obj :" + obj);
        System.out.println("clone :" + clone);
    }
}
