package com.ProducerConsumer;

import java.util.Queue;
import java.util.concurrent.Callable;

public class Consumer implements Callable{

    public Queue<Integer> queue;

    public Consumer(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public Object call() throws Exception {

        try {

            while (true) {

                while (queue.size() == 0) {

                    queue.wait();

                }

                System.out.println(" Consumed " + queue.remove());
                queue.notifyAll();

            }

        }catch (Exception e){

        }

        return null;

    }

}
