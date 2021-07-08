package org.daistudy.designpattern.creational.singleton;

/**
 * 饿汉式一
 */
public class SingleInstanceA1 {

    private SingleInstanceA1() {

    }

    private static SingleInstanceA1 single = new SingleInstanceA1();

    public static SingleInstanceA1 getInstance(){
        return single;
    }
}
