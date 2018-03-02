package com.multithreading;

import java.util.concurrent.ConcurrentHashMap;

public class WorkerThread implements Runnable {

    private String command;
    private volatile static ConcurrentHashMap<String, String > hashMap = new ConcurrentHashMap<>();
    private volatile static int count = 0;

    private void increment(){
        count = count + 1;
    }

    public WorkerThread(String s){
        this.command=s;
    }

    public void run() {

        increment();
        hashMap.put("key", "count" + count);
        System.out.println(hashMap.get("key"));
        System.out.println("Count = " + count);

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
