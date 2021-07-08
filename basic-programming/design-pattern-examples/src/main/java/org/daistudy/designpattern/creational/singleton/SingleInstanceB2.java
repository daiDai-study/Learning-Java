package org.daistudy.designpattern.creational.singleton;

/**
 * 懒汉式二：为解决懒汉式一种线程不安全的问题，通过同步（synchronized）方法，缺点就是效率低
 */
public class SingleInstanceB2 {
    private SingleInstanceB2(){}

    private static SingleInstanceB2 single = null;

    public static synchronized SingleInstanceB2 getInstance(){
        if (single == null) {
            single = new SingleInstanceB2();
        }
        return single;
    }
}
