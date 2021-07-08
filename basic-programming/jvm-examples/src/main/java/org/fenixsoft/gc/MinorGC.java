package org.fenixsoft.gc;

public class MinorGC {
    private static final int _MB = 1024 * 1024;

    /**
     * VM 参数： -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     */
    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _MB];
        allocation2 = new byte[2 * _MB];
        allocation3 = new byte[2 * _MB];
        allocation4 = new byte[4 * _MB]; // 出现一次 Minor GC
    }
}
