package org.daistudy.onjava.concurrent.demo;

import java.util.concurrent.*;

public class ImplementsCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("thread start");
        System.out.println(getClass().getName());
        Thread.sleep(2000);
        System.out.println("thread end");
        return Thread.currentThread().getName();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("main start");
        // 开启执行服务
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        // 启动方式一：
        // 启动线程，并获取结果
        Future<String> submit = executorService.submit(new ImplementsCallable());


        // 启动方式二：
        FutureTask<String> task = new FutureTask<>(new ImplementsCallable());
        executorService.submit(task);

        // 得到结果
        String result = submit.get();
        String result2 = task.get();

        // 关闭服务
        executorService.shutdownNow();

        System.out.println("result = " + result);
        System.out.println("result2 = " + result2);
        System.out.println("main end");
    }
}
