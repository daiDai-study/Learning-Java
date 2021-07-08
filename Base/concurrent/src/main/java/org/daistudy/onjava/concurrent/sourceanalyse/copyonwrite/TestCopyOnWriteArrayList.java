package org.daistudy.onjava.concurrent.sourceanalyse.copyonwrite;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 写时复制策略保证读的并发和写的线程安全
 * 缺点在于该策略会产生弱一致性，弱一致性是指读取第一次后，其他线程对 list 的修改对第一次读取的内容不可见
 * 也就是说一个线程可能读的是另一个线程改之前的数据；类似于产生了事务中的不可重复读和幻读
 */
public class TestCopyOnWriteArrayList {
    public static void main(String[] args) {
        new CopyOnWriteArrayList();
        System.out.println(int.class.getComponentType());
        System.out.println(Integer.class.getComponentType());
        System.out.println(Integer[].class.getComponentType());
        System.out.println((Object)Object[].class);
        System.out.println((Object)Integer[].class);
        System.out.println((Object)Integer[][].class);
        System.out.println((Object)Integer[].class == (Object)Object[].class);
    }
}
