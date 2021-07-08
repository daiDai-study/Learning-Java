package org.fenixsoft.classloading;

/**
 * 被动使用类字段演示一：
 * 通过数组定义来引用类，不会触发此类初始化
 */
public class NotInitialization2 {
    public static void main(String[] args) {
        SuperClass[] array = new SuperClass[10];
    }
}
