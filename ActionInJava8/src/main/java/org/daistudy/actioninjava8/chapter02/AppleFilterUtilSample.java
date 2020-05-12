package org.daistudy.actioninjava8.chapter02;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// 无法应对复杂查询，当有新的需求时，需要新添加一个方法，而且代码（迭代行为）重复
public class AppleFilterUtilSample {
    // 筛选绿苹果 -- 属性确定
    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if("green".equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }

    // 根据颜色筛选苹果 -- 一个颜色属性
    public static List<Apple> filterApplesByColor(List<Apple> inventory, String color){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if(Objects.equals(color, apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }

    // 根据体重筛选苹果 -- 一个体重属性
    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if(apple.getWeight() > weight){
                result.add(apple);
            }
        }
        return result;
    }

    // 结合多个属性 -- 调用时 flag 很笨拙
    public static List<Apple> filterApples(List<Apple> inventory, String color, int weight, boolean flag){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if((flag && Objects.equals(color, apple.getColor())) ||
                    (!flag && apple.getWeight() > weight)){
                result.add(apple);
            }
        }
        return result;
    }
}
