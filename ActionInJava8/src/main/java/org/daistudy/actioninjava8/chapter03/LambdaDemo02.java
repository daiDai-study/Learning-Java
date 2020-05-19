package org.daistudy.actioninjava8.chapter03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class LambdaDemo02 {
    public static void main(String[] args) {
        final Integer[] ints = {2, 4, 7, 9};
        // 使用了构造函数引用
        final List<Apple> apples = getApples(Arrays.asList(ints), Apple::new);

        // 创建实现类，利用多态
        apples.sort(new AppleComparator());

        // 使用匿名类
        apples.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });

        // 使用 Lambda
        apples.sort((o1, o2) -> o1.getWeight().compareTo(o2.getWeight()));

        // 对 Lambda 进行简化
        apples.sort(Comparator.comparing(o -> o.getWeight()));

        // 使用方法引用
        apples.sort(Comparator.comparing(Apple::getWeight));
    }

    public static List<Apple> getApples(List<Integer> weights, Function<Integer, Apple> appleFunction){
        List<Apple> apples = new ArrayList<>();
        for (Integer weight : weights) {
            apples.add(appleFunction.apply(weight));
        }
        return apples;
    }
}
