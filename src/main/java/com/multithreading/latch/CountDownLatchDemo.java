package com.multithreading.latch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args){

        System.out.println(" Hello !");
        CountDownLatch countDownLatch = new CountDownLatch(3);

        Thread alertService = new Thread(new Service("alertService", 10, countDownLatch));
        Thread valService = new Thread(new Service("valService", 10, countDownLatch));
        Thread cacheService = new Thread(new Service("cacheService", 10, countDownLatch));

        alertService.start();
        valService.start();
        cacheService.start();

        try{
            countDownLatch.await();  //main thread is waiting on CountDownLatch to finish
            System.out.println("All services are up, Application is starting now");
        }catch(InterruptedException ie){
            ie.printStackTrace();
        }
    }
}