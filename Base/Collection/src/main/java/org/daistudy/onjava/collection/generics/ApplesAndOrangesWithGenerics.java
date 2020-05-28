package org.daistudy.onjava.collection.generics;

// collections/ApplesAndOrangesWithGenerics.java

import java.util.ArrayList;

/**
 * 对集合使用泛型，可以确保集合的类型安全
 */
public class ApplesAndOrangesWithGenerics {
    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<>();
        for(int i = 0; i < 3; i++)
            apples.add(new Apple());
        // Compile-time error:
        // apples.add(new Orange());
        for(Apple apple : apples) {
            System.out.println(apple.id());
        }
    }
}
/* Output:
0
1
2
*/
