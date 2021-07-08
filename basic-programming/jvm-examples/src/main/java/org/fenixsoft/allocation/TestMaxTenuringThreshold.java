package org.fenixsoft.allocation;

/**
 * VM参数： -verbose:gc -XX:+UseSerialGC -XX:+PrintGC -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+PrintTenuringDistribution -XX:MaxTenuringThreshold=1
 *
 * -XX:MaxTenuringThreshold=15
 *
 * 如果在 Survivor 空间中相同年龄所有对象大小的总和大于 Survivor 空间的一半，年龄大于或等于该年龄的对象就可以直接进入老年代
 */
public class TestMaxTenuringThreshold {

    private static final int _1MB = 1024*1024;

    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[_1MB/8];
//        allocation2 = new byte[_1MB/8];
        allocation3 = new byte[4*_1MB];
        allocation4 = new byte[4*_1MB]; // 第一次 Minor GC
        allocation4 = null;
        allocation4 = new byte[4*_1MB]; // 第二次 Minor GC
    }

}
