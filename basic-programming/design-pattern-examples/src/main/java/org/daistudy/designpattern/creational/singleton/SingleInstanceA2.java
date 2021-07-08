package org.daistudy.designpattern.creational.singleton;

/**
 * 饿汉式二：与饿汉式一的区别就在于，在静态代码块中来创建实例对象。
 */
public class SingleInstanceA2 {
    private SingleInstanceA2() {

    }

    private static SingleInstanceA2 single;

    static {
        single = new SingleInstanceA2();
    }

    public static SingleInstanceA2 getInstance(){
        return single;
    }
}
