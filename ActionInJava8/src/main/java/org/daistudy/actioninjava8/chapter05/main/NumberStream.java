package org.daistudy.actioninjava8.chapter05.main;

import org.daistudy.actioninjava8.common.model.Dish;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumberStream {
    public static void main(String[] args) {
        final List<Dish> dishes = Dish.init();
        System.out.println(dishes.stream()
                .mapToInt(Dish::getCalories)
                .max()
                .orElse(1));

        System.out.println(IntStream.range(1, 100)
                .filter(n -> n % 2 == 0)
                .count());

        IntStream.rangeClosed(1, 100)
                .boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(a, 100)
                                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                                .mapToObj(b -> new Integer[]{a, b, (int) Math.sqrt(a * a + b * b)}))
                .map(Arrays::asList)
                .limit(10)
                .forEach(System.out::println);
    }
}
