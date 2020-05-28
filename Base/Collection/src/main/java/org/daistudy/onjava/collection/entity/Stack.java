package org.daistudy.onjava.collection.entity;

// onjava/Stack.java
// A Stack class built with an ArrayDeque

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 通过组合的方式而不是继承的方式的创建
 * Java 1.0 设计者在创建 java.util.Stack 时，就是通过继承的方式创建，导致公开了太多累赘的方法
 * 因此在使用 Stack 时，首先通过 ArrayDeque 组合的自定义类，不要使用 SDK 提供的 Stack
 * @param <T>
 */
public class Stack<T> {
    private Deque<T> storage = new ArrayDeque<>();
    public void push(T v) { storage.push(v); }
    public T peek() { return storage.peek(); }
    public T pop() { return storage.pop(); }
    public boolean isEmpty() { return storage.isEmpty(); }
    @Override
    public String toString() {
        return storage.toString();
    }
}
