package org.daistudy.concurrent.beauty.chap5.copyonwrite;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 写时复制策略保证读的并发和写的线程安全
 * 缺点在于该策略会产生迭代器的弱一致性，弱一致性是指读取获取迭代器后，其他线程对 list 的修改对获取的迭代器不可见
 */
public class TestCopyOnWriteArrayList {

    private static CopyOnWriteArrayList<String> copy = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        copy.add("hello");
        copy.add("world");
        copy.add("a");
        copy.add("b");
        copy.add("c");
        Thread thread = new Thread(() -> {
            copy.set(0, "hi");
            copy.remove(2);
        });
        // 保证线程修改前拿到迭代器
        Iterator<String> iterator = copy.iterator();
        thread.start();
        thread.join();
        // 线程修改后访问修改之前迭代器
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        // 线程修改后访问修改之后迭代器
        copy.forEach(System.out::println);
    }
}
