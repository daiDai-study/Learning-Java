package org.daistudy.designpattern.creational.singleton;

/**
 * 懒汉式四：与懒汉式三类似，也是针对产生实例化的的代码块进行同步，但为了提高效率，实现了双重检查
 */
public class SingleInstanceB4 {
    private SingleInstanceB4(){}

    private static SingleInstanceB4 single = null;

    public static SingleInstanceB4 getInstance(){
        if (single == null) {
            synchronized (SingleInstanceB4.class) {
                if (single == null){
                    single = new SingleInstanceB4();
                }
            }
        }
        return single;
    }
}
