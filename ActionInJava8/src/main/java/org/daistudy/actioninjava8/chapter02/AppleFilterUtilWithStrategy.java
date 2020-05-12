package org.daistudy.actioninjava8.chapter02;

import java.util.ArrayList;
import java.util.List;

// 利用多态的特性和策略设计模式进行重构
// 优点：去除了迭代代码的重复，也将做什么和怎么做区分开了，便于扩展新需求
// 缺点：每次添加一个新需求，都需要新建一个类，代码还是很臃肿 == 声明了很多只需要实例化一次的类
public class AppleFilterUtilWithStrategy {
    // predicate 还是对象引用
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate predicate){
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
        AppleFilterUtilWithStrategy.filterApples(inventory, new AppleHeavyWeightPredicate());
    }
}

class AppleHeavyWeightPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}

class AppleGreenColorPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
