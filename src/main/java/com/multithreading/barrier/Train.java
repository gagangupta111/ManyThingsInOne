package com.multithreading.barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Train implements Runnable{

    private CyclicBarrier cyclicBarrier;
    private String message;

    public Train(CyclicBarrier cyclicBarrier, String message) {

        this.cyclicBarrier = cyclicBarrier;
        this.message = message;

    }

    public void run() {

        System.out.println( message + " Awaiting at barrier !");

        try {

            cyclicBarrier.await();

        } catch (InterruptedException e) {

            e.printStackTrace();

        } catch (BrokenBarrierException e) {

            e.printStackTrace();

        }

        System.out.println(" Crossed the barrier !");

    }
}
