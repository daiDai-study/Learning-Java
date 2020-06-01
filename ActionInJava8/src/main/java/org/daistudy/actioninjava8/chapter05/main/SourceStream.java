package org.daistudy.actioninjava8.chapter05.main;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SourceStream {
    public static void main(String[] args) {
        // 由值创建流
        final Stream<String> stringStream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
        stringStream.map(String::toUpperCase).forEach(System.out::println);

        final Stream<Object> empty = Stream.empty();
        System.out.println(empty);

        // 由数组创建流
        System.out.println(Arrays.stream(new int[]{1, 2, 3}).sum());

        // 由文件创建流
        long count = 0;
        try (final Stream<String>
                     lines = Files.lines(Paths.get("src/main/java/org/daistudy/actioninjava8/chapter05/model/Transaction.java"), Charset.defaultCharset())){
            count = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(count);

        // 无限流 -- iterate
        System.out.println(Stream.iterate(0, a -> a + 2)
                .limit(10)
                .collect(Collectors.toList()));

        System.out.println(Stream.iterate(new Integer[]{0, 1}, a -> new Integer[]{a[1], a[0] + a[1]})
                .limit(10)
                .map(a -> a[0])
                .collect(Collectors.toList()));

        // 无限流 -- generate
        System.out.println(Stream.generate(Math::random)
                .limit(5)
                .collect(Collectors.toList()));

        System.out.println(IntStream.generate(new IntSupplier() {
            private int p = 0;
            private int c = 1;

            @Override
            public int getAsInt() {
                int op = this.p;
                int n = this.p + this.c;
                this.p = this.c;
                this.c = n;
                return op;
            }
        }).limit(10).boxed().collect(Collectors.toList()));
    }
}
