package com.ProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ProducerConsumer {

    public static final int MAX = 10;

    public static void main(String[] args){

        Queue<Integer> queue = new LinkedList<Integer>();

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        ExecutorService executorService = new ThreadPoolExecutor(5, 10, 1000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(10));
        executorService.submit(producer);
        executorService.submit(consumer);

    }

}
