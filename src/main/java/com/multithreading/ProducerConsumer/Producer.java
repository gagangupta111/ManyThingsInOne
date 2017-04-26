package com.multithreading.ProducerConsumer;

import java.util.List;

class Producer implements Runnable {

    private volatile int i = 0;
    private List<Integer> sharedQueue;
    private int maxSize=5; //maximum number of products which sharedQueue can hold at a time.

    public Producer(List<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    public void run() {

        while (true){  //produce 10 products.
            try {
                produce(i++);
            } catch (InterruptedException e) {  e.printStackTrace();   }
        }

    }

    private void produce(int i) throws InterruptedException {

        synchronized (sharedQueue) {
            //if sharedQuey is full wait until consumer consumes.
            while (sharedQueue.size() == maxSize) {
                System.out.println("Queue is full, producerThread is waiting for "
                        + "consumerThread to consume, sharedQueue's size= "+maxSize);
                sharedQueue.wait();
            }
        }

       /* 2 Synchronized blocks have been used means before
        * producer produces by entering below synchronized
        * block consumer can consume.
        */

        //as soon as producer produces (by adding in sharedQueue) it notifies consumerThread.
        synchronized (sharedQueue) {
            System.out.println("Produced : " + i);
            sharedQueue.add(i);
            Thread.sleep((long)(1000));
            sharedQueue.notify();
        }
    }
}