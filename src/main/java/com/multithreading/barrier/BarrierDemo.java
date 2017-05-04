package com.multithreading.barrier;

import java.util.concurrent.CyclicBarrier;

public class BarrierDemo{

    public static void main(String[] args){

        System.out.println(" Hello !");

        Barrier barrier = new Barrier();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, barrier);
        Thread train1 = new Thread(new Train(cyclicBarrier));
        Thread train2 = new Thread(new Train(cyclicBarrier));
        Thread train3 = new Thread(new Train(cyclicBarrier));

        train1.start();
        train2.start();
        train3.start();

    }

}
