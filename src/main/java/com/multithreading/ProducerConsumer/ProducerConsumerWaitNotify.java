package com.multithreading.ProducerConsumer;

import java.util.LinkedList;
import java.util.List;

public class ProducerConsumerWaitNotify {

    public static void main(String args[]) {

        List<Integer> sharedQueue = new LinkedList<Integer>(); //Creating shared object

        Producer producer=new Producer(sharedQueue);
        Consumer consumer=new Consumer(sharedQueue);

        Thread producerThread = new Thread(producer, "ProducerThread");
        Thread consumerThread = new Thread(consumer, "ConsumerThread");
        producerThread.start();
        consumerThread.start();

    }

}
