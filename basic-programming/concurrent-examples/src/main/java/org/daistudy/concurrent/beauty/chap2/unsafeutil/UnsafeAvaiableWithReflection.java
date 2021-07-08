package org.daistudy.concurrent.beauty.chap2.unsafeutil;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeAvaiableWithReflection {
    private static Unsafe unsafe;

    private volatile int state = 0;

    private static long stateOffset;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe)field.get(null); // 静态字段获取字段值时，不需要传入实例对象，传入的是 null

            stateOffset = unsafe.objectFieldOffset(UnsafeAvaiableWithReflection.class.getDeclaredField("state"));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UnsafeAvaiableWithReflection test = new UnsafeAvaiableWithReflection();
        System.out.println("before cas: " + test.state);
        System.out.println(unsafe.compareAndSwapInt(test, stateOffset, 0, 1));
        System.out.println("after cas: " + test.state);
    }
}
