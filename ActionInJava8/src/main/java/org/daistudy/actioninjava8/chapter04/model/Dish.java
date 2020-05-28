package org.daistudy.actioninjava8.chapter04.model;

public class Dish {
    private Integer calories;
    private String name;
    private Boolean vegerarian;
    private Type type;

    public Dish() {
    }

    public Dish( String name, Boolean vegerarian, Integer calories, Type type) {
        this.calories = calories;
        this.name = name;
        this.vegerarian = vegerarian;
        this.type = type;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public enum Type{ MEAT, FISH, OTHER}
}
