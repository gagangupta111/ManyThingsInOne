package com.multithreading.ExecutorService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolExample {

    public static void main(String[] args) {

        System.out.println(" Hello !");
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        //ExecutorService executorService = new ScheduledThreadPoolExecutor(10, threadFactory, new RejectedExecutionHandlerImpl());
        ExecutorService executorService = new ThreadPoolExecutor(5, 10, 1000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(10));
        List<Future> list = new ArrayList<Future>();

        for (int i = 0; i < 100; i++) {
            list.add(executorService.submit(new WorkerThread("" + i)));
        }

        for (Future future : list) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        List<Runnable> runnables = executorService.shutdownNow();
        System.out.println(runnables.size());

        for (Runnable task : runnables) {
            System.out.println(" Runnable " + runnables.getClass());
        }
    }
}
