package org.daistudy.onjava.concurrent.concept;

public class DeadLock {
    private static class C implements Runnable{
        private static A a = new A();
        private static B b = new B();

        private String name;
        private boolean flag;

        public C(String name, boolean flag) {
            this.name = name;
            this.flag = flag;
        }

        private void deadLock() throws InterruptedException {
            if(flag){
                synchronized (a){
                    System.out.println(Thread.currentThread().getName() + "获得锁" + a);
                    Thread.sleep(1000);
                    synchronized (b){
                        System.out.println(Thread.currentThread().getName() + "获得锁" + b);
                    }
                }
            }else{
                synchronized (b){
                    System.out.println(Thread.currentThread().getName() + "获得锁" + b);
                    Thread.sleep(1000);
                    synchronized (a){
                        System.out.println(Thread.currentThread().getName() + "获得锁" + a);
                    }
                }
            }
        }

        private void activeLock() throws InterruptedException {
            if(flag){
                synchronized (a){
                    System.out.println(Thread.currentThread().getName() + "获得锁 a");
                    Thread.sleep(1000);
                }
                synchronized (b){
                    System.out.println(Thread.currentThread().getName() + "获得锁 b");
                }
            }else{
                synchronized (b){
                    System.out.println(Thread.currentThread().getName() + "获得锁 b");
                    Thread.sleep(1000);
                }
                synchronized (a){
                    System.out.println(Thread.currentThread().getName() + "获得锁 a");
                }
            }
        }

        @Override
        public void run() {
            try {
                activeLock();
                deadLock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new C("1", true)).start();
        new Thread(new C("2", false)).start();
    }
}

class A{

}

class B{

}
