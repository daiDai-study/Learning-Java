package org.daistudy.onjava.object.copy.shallow.main;

public class SimpleObjectWithPrimitive implements Cloneable {

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "SimpleObjectWithPrimitive{" +
            "age=" + age +
            '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        SimpleObjectWithPrimitive obj = new SimpleObjectWithPrimitive();
        obj.setAge(1);
        SimpleObjectWithPrimitive clone = (SimpleObjectWithPrimitive)obj.clone();
        System.out.println("obj == clone :" + (obj == clone));
        System.out.println("obj.equals(clone) :" + (obj.equals(clone)));
        System.out.println("obj :" + obj);
        System.out.println("clone :" + clone);
    }
}
