package com.multithreading.latch;

import java.util.concurrent.CountDownLatch;

public class Service implements Runnable{

    private String name;
    private int time;
    private CountDownLatch countDownLatch;

    public Service(String name, int time, CountDownLatch countDownLatch) {
        this.name = name;
        this.time = time;
        this.countDownLatch = countDownLatch;
    }

    public void run() {

        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println( name +  " is started running !");
        countDownLatch.countDown();
    }
}