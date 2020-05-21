package org.daistudy.java.collections;

// collections/SimpleCollection.java
import java.util.*;

/**
 * for-in 语法支持 Collection 类型
 */
public class SimpleCollection {
    public static void main(String[] args) {
        Collection<Integer> c = new ArrayList<>();
        for(int i = 0; i < 10; i++)
            c.add(i); // Autoboxing
        for(Integer i : c)
            System.out.print(i + ", ");
    }
}
/* Output:
0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
*/
