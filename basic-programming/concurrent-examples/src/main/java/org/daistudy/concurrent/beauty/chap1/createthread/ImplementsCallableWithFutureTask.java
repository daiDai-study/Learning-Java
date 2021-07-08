package org.daistudy.concurrent.beauty.chap1.createthread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ImplementsCallableWithFutureTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("a child thread start");
        Thread.sleep(2000);
        System.out.println("a child thread end");
        return Thread.currentThread().getName();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("main start");

        FutureTask<String> task = new FutureTask<>(new ImplementsCallableWithFutureTask());
        new Thread(task).start();
        try{
//            while(!task.isDone()){
//                System.out.println("等待。。。");
//                Thread.sleep(500);
//            }
            String result = task.get();
            System.out.println("result = " + result);
        }catch (ExecutionException e){
            e.printStackTrace();
        }

        System.out.println("main end");
    }
}
