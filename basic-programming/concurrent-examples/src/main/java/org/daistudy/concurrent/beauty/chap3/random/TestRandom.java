package org.daistudy.concurrent.beauty.chap3.random;


import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Java 中的 Random 类的理论依据是线性同余法，其产生的随机数都是伪随机数（具有周期的）
 * 计算公式：x(n+1) = (a*x(n)+c)mod(m)，x(i)就是种子
 *
 * Random 类是线程安全的，内部采用 CAS 自旋锁保证种子变化的线程安全性，这也影响了多线程的并发性能
 * Random 类不是加密的
 *
 * 线程安全且并发性能高，用 ThreadLocalRandom.current()
 * 加密，用 new SecureRandom()
 */
public class TestRandom {
    public static void main(String[] args) {
        Random random = new Random(1);
        int i = random.nextInt();
        Random random1 = new Random(1);
        int i1 = random1.nextInt();

        ThreadLocalRandom current = ThreadLocalRandom.current();

        new Thread(() -> {
            System.out.println(current.nextInt());
        }).start();
        new Thread(() -> {
            System.out.println(current.nextInt());
        }).start();

        SecureRandom secureRandom = new SecureRandom();
        int i2 = secureRandom.nextInt();
        SecureRandom secureRandom1 = new SecureRandom();
        int i3 = secureRandom1.nextInt();
    }
}
