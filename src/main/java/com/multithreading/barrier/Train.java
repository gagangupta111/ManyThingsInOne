package com.multithreading.barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Train implements Runnable{

    private CyclicBarrier cyclicBarrier;

    public Train(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    public void run() {

        System.out.println(" Awaiting at barrier !");
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
