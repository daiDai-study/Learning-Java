package org.daistudy.onjava.collection.iterator;

// collections/IterableClass.java
// Anything Iterable works with for-in

import java.util.Iterator;

/**
 * 任何实现了 Iterable 的类，都可以将它用于 for-in 语句
 */
public class IterableClass implements Iterable<String> {
    protected String[] words = ("And that is how " + "we know the Earth to be banana-shaped.").split(" ");
    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < words.length;
            }
            @Override
            public String next() { return words[index++]; }
            @Override
            public void remove() { // Not implemented
                throw new UnsupportedOperationException();
            }
        };
    }
    public static void main(String[] args) {
        for(String s : new IterableClass())
            System.out.print(s + " ");
    }
}
/* Output:
And that is how we know the Earth to be banana-shaped.
*/
