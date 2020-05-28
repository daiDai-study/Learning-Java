package org.daistudy.onjava.collection.collections;

import java.util.Collections;
import java.util.List;

/**
 * 通过 Collections 的 emptyList()（emptySet()）方法返回的是一个不可变的集合，同 Arrays.asList()
 */
public class EmptyCollection {
    public static void main(String[] args) {
        List<String> emptyList = Collections.emptyList();
        emptyList.add("1");
    }
}
