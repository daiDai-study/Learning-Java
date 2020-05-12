package org.daistudy.actioninjava8.chapter02;

import java.util.ArrayList;
import java.util.List;

// 通过匿名类，可以去除实现类的声明，可以当用户在使用方法的同时直接声明和实例化一个类
// 优点：代码更加简洁了
// 缺点：代码还是包含许多模板代码，而且代码还不够语义化
// 注意：匿名类中的 this 指向匿名类当前实例
public class AppleFilterUtilWithAnonymousClass {
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
        AppleFilterUtilWithStrategy.filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "green".equals(apple.getColor());
            }
        });
    }
}
