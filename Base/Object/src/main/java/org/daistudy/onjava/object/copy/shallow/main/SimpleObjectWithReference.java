package org.daistudy.onjava.object.copy.shallow.main;

import org.daistudy.onjava.object.copy.shallow.model.SimpleObject;

public class SimpleObjectWithReference implements Cloneable {

    private Object name;

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SimpleObjectWithReference{" +
            "name=" + name +
            '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        SimpleObjectWithReference obj = new SimpleObjectWithReference();
        obj.setName(new SimpleObject("1", 1));
        SimpleObjectWithReference clone = (SimpleObjectWithReference)obj.clone();
        SimpleObject name = (SimpleObject)clone.getName();
        name.setName("2");
        name.setAge(2);
        System.out.println("obj == clone :" + (obj == clone));
        System.out.println("obj.equals(clone) :" + (obj.equals(clone)));
        System.out.println("obj :" + obj);
        System.out.println("clone :" + clone);
    }
}
