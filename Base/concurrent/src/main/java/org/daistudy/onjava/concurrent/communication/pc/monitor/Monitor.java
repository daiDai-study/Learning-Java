package org.daistudy.onjava.concurrent.communication.pc.monitor;

/**
 * 管程法
 * 生产者、消费者、缓冲区（产品）
 */
public class Monitor {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(10);
        new Producer(buffer).start();
        new Consumer(buffer).start();
    }
}

class Producer extends Thread{
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            buffer.push(new Product(i + 1));
        }
    }
}

class Consumer extends Thread{
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            buffer.pop();
        }
    }
}

class Product{
    int id;

    public Product(int id) {
        this.id = id;
    }
}

class Buffer{
    private Product[] products;

    private int size;

    private int count;

    public Buffer(int size) {
        if(size <= 0){
            throw new IllegalArgumentException("缓冲区的初始容量必须大于0");
        }
        this.size = size;
        this.products = new Product[size];
        this.count = 0;
    }

    // 放入产品
    public synchronized void push(Product product) {
        // 满了，需要通知消费者消费，生产者需要等待
        if(count >= size){
            System.out.println("生产者需要等待");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 没满，加入到缓冲去，并通知消费者消费
        System.out.println("生产者生产了一个新产品，id：" + product.id);
        this.products[count++] = product;
        this.notifyAll();
    }

    // 弹出产品
    public synchronized Product pop() {
        // 没了，生产者生产，消费者等待
        if(count <= 0){
            System.out.println("消费者需要等待");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 有，消费者消费
        Product product = this.products[--count];
        System.out.println("消费者消费了一个产品，id：" + product.id);
        this.notifyAll();
        return product;
    }
}
