package com.ProducerConsumer;

import java.util.Queue;
import java.util.concurrent.Callable;

public class Producer implements Callable{

    public Queue<Integer> queue;
    public volatile static int count = 0;

    public Producer(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public synchronized Object call() throws Exception {

        try {

            while (true) {

                while (queue.size() >= ProducerConsumer.MAX) {

                    queue.wait();

                }

                queue.add(count);
                System.out.println(" Produced " + count++);
                queue.notifyAll();

            }
        }catch (Exception e){}
        return null;

    }
}
