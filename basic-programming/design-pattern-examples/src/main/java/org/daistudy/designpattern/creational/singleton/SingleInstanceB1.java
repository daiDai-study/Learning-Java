package org.daistudy.designpattern.creational.singleton;

/**
 * 懒汉式一：多线程不安全，只能在单线程下使用
 */
public class SingleInstanceB1 {
    private SingleInstanceB1(){}

    private static SingleInstanceB1 single = null;

    public static SingleInstanceB1 getInstance(){
        if(single == null){
            single = new SingleInstanceB1();
        }
        return single;
    }
}
