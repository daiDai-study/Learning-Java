package org.daistudy.concurrent.beauty.chap1.waitandnotify;

/**
 * resourceA.wait() 只释放 resourceA 上的锁，并没有释放其他资源（resourceB）的锁
 */
public class WaitReleaseLock {
    private static Object resourceA = new Object();
    private static Object resourceB = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(() -> {
            String name = Thread.currentThread().getName();
            try {
                synchronized (resourceA) {
                    System.out.println(name + " get resourceA lock");
                    synchronized (resourceB) {
                        System.out.println(name + " get resourceB lock");

                        System.out.println(name + " release resourceA lock");
                        resourceA.wait(); // 只释放 resouceA 上的锁，并没有释放其他资源（resourceB）的锁
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "threadA");

        Thread threadB = new Thread(() -> {
            String name = Thread.currentThread().getName();
            try {
                Thread.sleep(1000);
                synchronized (resourceA) {
                    System.out.println(name + " get resourceA lock");
                    synchronized (resourceB) {
                        System.out.println(name + " get resourceB lock");

                        System.out.println(name + " release resourceA lock");
                        resourceA.wait();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "threadB");

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();

        System.out.println("main over");
    }
}

