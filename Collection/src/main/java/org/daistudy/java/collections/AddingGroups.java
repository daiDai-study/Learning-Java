package org.daistudy.java.collections;

// collections/AddingGroups.java
// Adding groups of elements to Collection objects
import java.util.*;

/**
 * Collection.addAll 只能添加集合类型（Collection）
 * Collections.addAll 只能添加数组或逗号分隔的参数列表（可变参数列表），而且运行更快，是首选方式
 */
public class AddingGroups {
    public static void main(String[] args) {
        Collection<Integer> collection =
                new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] moreInts = { 6, 7, 8, 9, 10 };
        collection.addAll(Arrays.asList(moreInts));
        // Runs significantly faster, but you can't
        // construct a Collection this way:
        Collections.addAll(collection, 11, 12, 13, 14, 15);
        Collections.addAll(collection, moreInts);
        // Produces a list "backed by" an array:
        List<Integer> list = Arrays.asList(16,17,18,19,20);
        list.set(1, 99); // OK -- modify an element
        // list.add(21); // Runtime error; the underlying
        // array cannot be resized.
    }
}
