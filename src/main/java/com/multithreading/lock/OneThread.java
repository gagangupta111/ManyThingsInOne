package com.multithreading.lock;

public class OneThread implements Runnable {

    private String name;
    private Lock lock;
    private volatile int count = 0;

    public OneThread(String name, Lock lock){

        this.name = name;
        this.lock = lock;

    }

    public void run() {

        try {

            lock.lock();
            System.out.println(" Total threads : " + lock.total_threads);
            System.out.println(" Locked by thread : " + name);
            // Thread.sleep(1000);
            print();

        } catch (InterruptedException e) {

            e.printStackTrace();

        }
    }

    public void print(){

        printAnother();
        lock.unlock();
        System.out.println(" Un-locked by thread : " + name);

    }

    public void printAnother(){

        try {

            lock.lock();
            System.out.println(" Again Locked by thread : " + name);
            System.out.println(" printAnother ");
            System.out.println(" Un-Locked by thread : " + name);
            lock.unlock();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}