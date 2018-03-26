package com.multithreading.ExecutorService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class MyCallable implements Callable<String> {

    AtomicInteger atomicInteger = new AtomicInteger(100);

    public String call() throws Exception {

        System.out.println(Thread.currentThread().getName());
        System.out.println(atomicInteger.getAndIncrement());
        return Thread.currentThread().getName();

    }

    public static void main(String args[]){

        //Get ExecutorService from Executors utility class, thread pool size is 10
        ExecutorService executor = Executors.newFixedThreadPool(10);
        //create a list to hold the Future object associated with Callable
        List<Future<String>> list = new ArrayList<Future<String>>();
        //Create MyCallable instance
        Callable<String> callable = new MyCallable();

        for(int i=0; i< 100; i++){

            Future<String> future = executor.submit(callable);
            list.add(future);

        }

        executor.shutdown();

    }

}
