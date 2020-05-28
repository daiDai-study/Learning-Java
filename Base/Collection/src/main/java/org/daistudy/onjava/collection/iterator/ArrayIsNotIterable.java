package org.daistudy.onjava.collection.iterator;

// collections/ArrayIsNotIterable.java

import java.util.Arrays;

/**
 * for-in 语句适用于数组或其它任何 Iterable ，但这并不意味着数组肯定也是个 Iterable
 */
public class ArrayIsNotIterable {
    static <T> void test(Iterable<T> ib) {
        for(T t : ib)
            System.out.print(t + " ");
    }
    public static void main(String[] args) {
        test(Arrays.asList(1, 2, 3));
        String[] strings = { "A", "B", "C" };
        // An array works in for-in, but it's not Iterable:
        //- test(strings);
        // You must explicitly convert it to an Iterable:
        test(Arrays.asList(strings));
    }
}
/* Output:
1 2 3 A B C
*/
