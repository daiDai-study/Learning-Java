package org.fenixsoft.allocation;

/**
 * VM参数： -verbose:gc -XX:+UseSerialGC -XX:+PrintGC -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
 *
 * 3145728 就是 3MB, PretenureSizeThreshold 参数不能与 -Xmx 之类的参数一样直接写 3MB
 */
public class TestPretenureSizeThreshold {

    private static final int _1MB = 1024*1024;

    public static void main(String[] args) {
        byte[] allocation;
        allocation = new byte[4*_1MB]; // 直接分配到老年代
    }
}
