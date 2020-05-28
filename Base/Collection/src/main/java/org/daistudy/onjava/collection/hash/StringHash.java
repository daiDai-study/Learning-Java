package org.daistudy.onjava.collection.hash;

public class StringHash {
    public static void main(String[] args) {
        String a = "a";
        System.out.println((int)'a');
        System.out.println(a.hashCode());
        String b = new String("a");
        System.out.println(b.hashCode());
    }
}
