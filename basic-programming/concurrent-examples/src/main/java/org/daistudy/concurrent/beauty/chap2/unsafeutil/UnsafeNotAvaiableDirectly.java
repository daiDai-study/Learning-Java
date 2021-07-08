package org.daistudy.concurrent.beauty.chap2.unsafeutil;

import sun.misc.Unsafe;

public class UnsafeNotAvaiableDirectly {
    private final static Unsafe unsafe = Unsafe.getUnsafe();

    private volatile int state = 0;

    private static long stateOffset;

    static {
        try {
            stateOffset = unsafe.objectFieldOffset(UnsafeNotAvaiableDirectly.class.getDeclaredField("state"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UnsafeNotAvaiableDirectly test = new UnsafeNotAvaiableDirectly();
        System.out.println(unsafe.compareAndSwapInt(test, stateOffset, 0, 1));
    }
}
