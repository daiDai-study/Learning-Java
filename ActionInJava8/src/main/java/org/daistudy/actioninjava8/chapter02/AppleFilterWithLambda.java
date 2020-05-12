package org.daistudy.actioninjava8.chapter02;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AppleFilterWithLambda {
    // predicate 是对象引用吗？？？
    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> predicate){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if(predicate.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        AppleFilterWithLambda.filterApples(inventory, apple -> "green".equals(apple.getColor()));
    }
}
