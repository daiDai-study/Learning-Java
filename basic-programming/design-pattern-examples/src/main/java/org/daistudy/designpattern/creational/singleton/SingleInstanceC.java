package org.daistudy.designpattern.creational.singleton;

/**
 * 静态内部类方式：既考虑了多线程安全的问题，也达到延迟加载的效果
 */
public class SingleInstanceC {
    private SingleInstanceC(){}

    public static SingleInstanceC getInstance(){
        return getSingleInstance.single;
    }

    private static class getSingleInstance{
        private static SingleInstanceC single = new SingleInstanceC();
    }
}
