package org.daistudy.actioninjava8.common.model;

import java.util.Arrays;
import java.util.List;

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

    public Boolean getVegerarian() {
        return vegerarian;
    }

    public void setVegerarian(Boolean vegerarian) {
        this.vegerarian = vegerarian;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public enum Type{ MEAT, FISH, OTHER}

    public static List<Dish> init(){
        List<Dish> dishes = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );
        return dishes;
    }
}
