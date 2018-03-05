package com.multithreading.barrier;

import java.util.concurrent.CyclicBarrier;

public class BarrierDemo{

    public static void main(String[] args) throws InterruptedException {

        System.out.println(" Hello !");

        Barrier barrier = new Barrier();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, barrier);
        Thread train1 = new Thread(new Train(cyclicBarrier, " One "));
        Thread train2 = new Thread(new Train(cyclicBarrier, " Two "));
        Thread train3 = new Thread(new Train(cyclicBarrier, " Three "));

        train1.start();
        train2.start();
        train3.start();

    }

}
