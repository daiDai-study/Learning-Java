package org.daistudy.actioninjava8.chapter04.main;

import org.daistudy.actioninjava8.chapter04.model.Dish;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 从给定的菜单（dish）中查出所有热量低于400的菜，并按热量从高到低的顺序将菜名取出
 */
public class SimpleDemo {
    public static void main(String[] args) {
        List<Dish> dishes = init();
//        List<String> dishNameList = actionInJava7(dishes);
//        System.out.println(dishNameList);
//
//        List<String> dishNameList2 = actionInJava8(dishes);
//        System.out.println(dishNameList2);

        List<String> threeHighCaloriesDishNames =
                dishes.stream()
                .filter(dish -> {
                    System.out.println("filter: "+dish.getName());
                    return dish.getCalories() > 500;
                })
                .limit(3)
                .map(dish -> {
                    System.out.println("map: "+dish.getName());
                    return dish.getName();
                })
                .collect(Collectors.toList());
        System.out.println(threeHighCaloriesDishNames);

//        final Stream<String> stream = Arrays.asList("Java8", "in", "Action").stream();
//        stream.forEach(System.out::println);
//        stream.forEach(System.out::println);
    }

    static List<Dish> init(){
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

    static List<String> actionInJava7(List<Dish> dishes){
        List<Dish> lowCaloriesDishes = new ArrayList<>();

        // 1.筛选
        for (Dish dish : dishes) {
            if(dish.getCalories() < 400){
                lowCaloriesDishes.add(dish);
            }
        }

        // 2.排序
        Collections.sort(lowCaloriesDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o2.getCalories(), o1.getCalories());
            }
        });

        // 3.取菜名
        List<String> dishNameList = new ArrayList<>();
        for (Dish lowCaloriesDish : lowCaloriesDishes) {
            dishNameList.add(lowCaloriesDish.getName());
        }
        return dishNameList;
    }

    static List<String> actionInJava8(List<Dish> dishes){
        return dishes.stream()
                .filter(dish -> dish.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories).reversed())
                .map(Dish::getName)
                .collect(Collectors.toList());
    }
}
