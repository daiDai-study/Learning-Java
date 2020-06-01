package org.daistudy.actioninjava8.chapter05.main;

import org.daistudy.actioninjava8.common.model.Dish;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleStream {
    public static void main(String[] args) {
        final List<Dish> dishes = Dish.init();

        // filter
        System.out.println("\nfilter:");
        final List<Dish> vegerarianMenu = dishes.stream()
                .filter(Dish::getVegerarian)
                .collect(Collectors.toList());
        System.out.println(vegerarianMenu);

        // distinct
        System.out.println("\ndistinct:");
        final List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .distinct()
                .filter(a -> a % 2 == 0)
                .forEach(System.out::println);

        // limit -- 有序流
        System.out.println("\nlimit:");
        dishes.stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3)
                .forEach(System.out::println);

        // limit -- 无序流
        final HashSet<Integer> integerHashSet = new HashSet<>(Arrays.asList(2, 3, 5, 1, 6));
        integerHashSet.stream()
                .limit(2)
                .forEach(System.out::println);

        // skip
        System.out.println("\nskip:");
        dishes.stream()
                .skip(8)
                .forEach(System.out::println);

        // map
        System.out.println("\nmap:");
        final List<Integer> collect = dishes.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(collect);

        // anyMatch
        System.out.println("\nanyMatch:");
        System.out.println(dishes.stream().anyMatch(Dish::getVegerarian));

        // allMatch
        System.out.println("\nallMatch:");
        System.out.println(dishes.stream().allMatch(dish -> dish.getCalories() < 1000));

        // noneMatch
        System.out.println("\nnoneMatch:");
        System.out.println(dishes.stream().noneMatch(dish -> dish.getCalories() > 1000));


        // findAny
        System.out.println("\nfindAny:");
        dishes.stream()
                .filter(Dish::getVegerarian)
                .findAny()
                .ifPresent(System.out::println);

        // findFirst
        System.out.println("\nfindFirst:");
        final List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        integers.stream()
                .map(a -> a * a)
                .filter(x -> x%3==0)
                .findFirst()
                .ifPresent(System.out::println);

        // reduce
        System.out.println("\nreduce1:");
        System.out.println(integers.stream()
                .reduce(0, Integer::sum));

        System.out.println("\nreduce2:");
        System.out.println(integers.stream()
                .reduce((a, b) -> a * b));

        System.out.println("\nreduce3:");
        dishes.stream()
                .map(dish -> 1)
                .reduce(Integer::sum)
                .ifPresent(System.out::println);
    }
}
