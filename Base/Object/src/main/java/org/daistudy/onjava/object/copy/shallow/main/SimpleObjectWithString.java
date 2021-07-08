package org.daistudy.onjava.object.copy.shallow.main;

public class SimpleObjectWithString implements Cloneable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SimpleObjectWithString{" +
            "name='" + name + '\'' +
            '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        SimpleObjectWithString obj = new SimpleObjectWithString();
        String nameOfObj = "1";
        obj.setName(nameOfObj);
        SimpleObjectWithString clone = (SimpleObjectWithString)obj.clone();
        String nameOfClone = clone.getName();
        System.out.println("obj == clone :" + (obj == clone));
        System.out.println("obj.equals(clone) :" + (obj.equals(clone)));
        System.out.println("obj :" + obj);
        System.out.println("clone :" + clone);

        System.out.println("obj.name == clone.name :" + (nameOfObj == nameOfClone));
        System.out.println("obj.name.equals(clone.name) :" + (nameOfObj.equals(nameOfClone)));
    }
}
