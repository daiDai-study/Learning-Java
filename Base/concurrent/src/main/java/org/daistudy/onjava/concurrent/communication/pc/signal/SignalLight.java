package org.daistudy.onjava.concurrent.communication.pc.signal;

public class SignalLight {
    public static void main(String[] args) {
        Product product = new Product();
        new Producer(product).start();
        new Consumer(product).start();
    }
}

class Producer extends Thread{
    private Product product;

    public Producer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            product.produce(i + 1);
        }
    }
}

class Consumer extends Thread{
    private Product product;

    public Consumer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            product.consume();
        }
    }
}

class Product{
    private int id;

    private boolean flag = false;

    // 生产
    public synchronized void produce(int id){
        if(flag){
            System.out.println("生产者需要等待消费者消费");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.id = id;
        System.out.println("生产者生产了产品，id：" + id);
        this.flag = !this.flag;
        this.notifyAll();
    }

    // 消费
    public synchronized void consume(){
        if(!flag){
            System.out.println("消费者需要等待生产者生产");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("消费者消费了产品，id：" + id);
        this.flag = !this.flag;
        this.notifyAll();
    }
}