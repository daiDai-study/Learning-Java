package org.daistudy.concurrent.beauty.chap6.locksupport;

import java.util.concurrent.locks.LockSupport;

public class ParkWithBlocker {
    public void testPark(){
        LockSupport.park(this);
    }

    public static void main(String[] args) {
        ParkWithBlocker parkWithBlocker = new ParkWithBlocker();
        parkWithBlocker.testPark();
    }
}
