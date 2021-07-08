package org.fenixsoft.allocation;

/**
 * VM参数： -verbose:gc -XX:+UseSerialGC -XX:+PrintGC -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 *
 * -XX:HandlePromotionFailure=false 关闭分配担保
 * -XX:HandlePromotionFailure=true 开启分配担保
 *
 * -XX:HandlePromotionFailure 在 JDK 6 Update 24 之后无效，默认就是开启分配担保
 */
public class TestHandlePromotionFailure {

    private static final int _1MB = 1024*1024;

    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4, allocation5, allocation6, allocation7, allocation8, allocation9;
        allocation1 = new byte[2*_1MB];
        allocation2 = new byte[2*_1MB];
        allocation3 = new byte[2*_1MB];
//        allocation4 = new byte[2*_1MB];
        allocation1 = null;
        allocation2 = null;
        allocation5 = new byte[2*_1MB]; //
        allocation6 = new byte[2*_1MB];
        allocation7 = new byte[2*_1MB];
//        allocation8 = new byte[2*_1MB];
        allocation5 = null;
        allocation6 = null;
        allocation7 = null;
        allocation8 = null;
        allocation9 = new byte[2*_1MB];
    }

}
