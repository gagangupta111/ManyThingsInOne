package com.multithreading.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {

    public static void main(String[] args){

        System.out.println(" Hello !");

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Lock lock = new Lock();

        for (int i = 0; i < 5; i++){

            OneThread oneThread = new OneThread(i + "", lock);
            executorService.submit(oneThread);

        }

        executorService.shutdown();

        java.util.concurrent.locks.Lock lock1 = new ReentrantLock(true);


    }
}