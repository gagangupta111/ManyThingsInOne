package com.multithreading.ExecutorService;

import java.util.concurrent.atomic.AtomicInteger;

public class WorkerThread implements Runnable {

    private AtomicInteger atomicInteger = new AtomicInteger(100);

    private String command;

    public WorkerThread(String s){
        this.command=s;
    }


    public void run() {
        System.out.println(Thread.currentThread().getName()+" Start. Command = "+command);
        processCommand();
        System.out.println(Thread.currentThread().getName()+" End.");
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return this.command;
    }
}
