package org.daistudy.onjava.collections.entity.pets;

public class Pet implements Comparable{
    private static int count;
    private int id = count++;
    public int id(){
        return this.id;
    }

    private String name;

    public Pet(){

    }

    public Pet(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name == null ? this.getClass().getSimpleName() : this.name;
    }

    @Override
    public int compareTo(Object o) {
        return this.toString().compareToIgnoreCase(o.toString());
    }
}
