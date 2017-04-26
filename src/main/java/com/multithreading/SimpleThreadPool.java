package com.multithreading;

import java.util.concurrent.*;

public class SimpleThreadPool {

    public static void main(String[] args) {

        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        ThreadPoolExecutor executorPool = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2), threadFactory, new RejectedExecutionHandlerImpl());

        for (int i = 0; i < 10; i++) {

            Runnable worker = new WorkerThread("" + i);
            executorPool.execute(worker);

        }

        executorPool.shutdown();

        while (!executorPool.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }
}