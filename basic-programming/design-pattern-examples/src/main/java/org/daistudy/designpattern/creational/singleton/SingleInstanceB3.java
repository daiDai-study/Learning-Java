package org.daistudy.designpattern.creational.singleton;

/**
 * 懒汉式三：与懒汉式二的区别就在于同步的地方不同，摒弃同步方法，改为同步产生实例化的的代码块，虽然效率相对懒汉式二较高，但本身的效率还是很低
 */
public class SingleInstanceB3 {
    private SingleInstanceB3(){}

    private static SingleInstanceB3 single = null;

    public static SingleInstanceB3 getInstance(){
        synchronized (SingleInstanceB3.class) {
            if(single == null){
                single = new SingleInstanceB3();
            }
        }
        return single;
    }
}
