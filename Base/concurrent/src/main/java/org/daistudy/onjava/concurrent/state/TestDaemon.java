package org.daistudy.onjava.concurrent.state;

public class TestDaemon {

    private static class Person implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i <= 36500; i += 100) {
                System.out.println("开心地活着");
            }
            System.out.println("不带走一片云彩，走了");
        }
    }

    private static class God implements Runnable{
        @Override
        public void run() {
            while (true){
                System.out.println("上帝守护者你");
            }
        }
    }

    public static void main(String[] args) {
        Thread god = new Thread(new God());
        Thread person = new Thread(new Person());
        god.setDaemon(true);

        god.start();
        person.start();
    }
}
