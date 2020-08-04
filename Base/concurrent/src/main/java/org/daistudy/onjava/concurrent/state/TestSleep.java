package org.daistudy.onjava.concurrent.state;

import java.text.SimpleDateFormat;
import java.util.Date;

// 模拟计时
public class TestSleep {
    public static void main(String[] args) {
        try {
            countDown(10);
            showTime(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 模拟倒计时多少秒
    private static void countDown(long second) throws InterruptedException {
        while(true){
            if(second<=0){
                break;
            }
            System.out.println("second = " + second--);
            Thread.sleep(1000);
        }
    }

    // 模拟计时器，每秒显示当前时间
    private static void showTime(long second) throws InterruptedException {
        Date date;
        while(true){
            if(second<=0){
                break;
            }
            second--;
            date = new Date();
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(date));
            Thread.sleep(1000);
        }
    }
}
