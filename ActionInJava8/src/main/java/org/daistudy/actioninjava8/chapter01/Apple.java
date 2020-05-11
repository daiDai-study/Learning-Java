package org.daistudy.actioninjava8.chapter01;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Apple {
    private String color;
    private Integer weight;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public static List<Apple> filterGreenApples(List<Apple> inventory){
        // 普通方式
//        List<Apple> result = new ArrayList<>();
//        for (Apple apple : inventory) {
//            if("green".equals(apple.getColor())){
//                result.add(apple);
//            }
//        }
//        return result;

        // 方法引用 适用于方法内代码行数长的
//        return filterApples(inventory, Apple::isGreenApple);

        // Lambda 更为简洁，不需要为 Predicate 中的类写方法，但也仅适用于 Lambda 长度多于几行的
//        return filterApples(inventory, apple -> "green".equals(apple.getColor()));

        // 使用顺序流处理
//        return inventory.stream().filter(apple -> "green".equals(apple.getColor())).collect(Collectors.toList());

        // 使用并行流处理
        return inventory.parallelStream().filter(apple -> "green".equals(apple.getColor())).collect(Collectors.toList());
    }

    public static List<Apple> filterHeavyApples(List<Apple> inventory){
        // 普通方式
//        List<Apple> result = new ArrayList<>();
//        for (Apple apple : inventory) {
//            if(apple.getWeight() > 150){
//                result.add(apple);
//            }
//        }
//        return result;

        // 方法引用
//        return filterApples(inventory, Apple::isHeavyApple);

        // Lambda
        return filterApples(inventory, apple -> apple.getWeight() > 150);
    }

    // 静态方法
//    public static boolean isGreenApple(Apple apple){
//        return "green".equals(apple.getColor());
//    }
//
//    public static boolean isHeavyApple(Apple apple){
//        return apple.getWeight() > 150;
//    }

    // 实例方法
    public boolean isGreenApple(){
        return "green".equals(this.getColor());
    }

    public boolean isHeavyApple(){
        return this.getWeight() > 150;
    }


    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }
}
