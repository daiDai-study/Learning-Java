package org.daistudy.actioninjava8.chapter05.main;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapOfStream {
    public static void main(String[] args) {
        // 对于一张单词表，如何返回一个列表，显示里面各不相同的字符
        final List<String> strings = Arrays.asList("Hello", "World");
        System.out.println(strings);

        System.out.println("\nmap:");
        strings.stream()
                .map(s -> s.split(""))
                .distinct()
                .map(Arrays::asList)
                .forEach(System.out::println);

        System.out.println("\nArrays.stream():");
        final List<Stream<String>> collect = strings.stream()
                .map(s -> s.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        for (Stream<String> stringStream : collect) {
            stringStream.forEach(System.out::print);
        }

        System.out.println("\n\nflatMap1:");
        strings.stream()
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .forEach(System.out::print);

        final List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        final List<Integer> numbers2 = Arrays.asList(3, 4);

        System.out.println("\n\nflatMap2:");
        numbers1.stream()
                .flatMap(a -> numbers2.stream().map(b -> new Integer[]{a, b}))
                .map(Arrays::asList)
                .forEach(System.out::println);

        System.out.println("\n\nflatMap3:");
        numbers1.stream()
                .flatMap(a -> numbers2.stream().filter(b -> (a+b)%3==0).map(b -> new Integer[]{a, b}))
                .map(Arrays::asList)
                .forEach(System.out::println);
    }
}
