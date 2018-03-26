package com.multithreading.ProducerConsumer.onemore;

import java.util.LinkedList;
import java.util.List;

public class Test {

    public static void main(String[] args){

        System.out.printf(" Hello! ");

        for (int i = 0; i < 10; i++){

            Thread a = new Thread(new Producer(Queue.getInstance(), "AAAA" + i));
            a.start();
            Thread b = new Thread(new Consumer(Queue.getInstance(), "BBBB" + i));
            b.start();

        }

        System.out.printf(" Hello! ");

    }

}

class Queue{

    private List<Integer> list;
    private static volatile Queue queue;

    private Queue() {

        list = new LinkedList<Integer>();

    }

    public static Queue getInstance(){

        if (queue == null){

            synchronized (Queue.class){

                if (queue == null){
                    queue = new Queue();
                }
            }
        }

        return queue;

    }

    public int getSize(){

        return list.size();

    }

    public void add(Integer integer){

        list.add(integer);

    }

    public int pop(){

        Integer integer = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return integer;

    }

    public void print(){

        System.out.println(this.list);

    }


}

class Producer implements Runnable{

    private Queue queue;
    private String name;
    private static volatile int count = 0;

    public Producer(Queue queue, String name) {
        this.queue = queue;
        this.name = name;
    }

    @Override
    public void run() {

        produce();

    }

    private void produce(){

        while (true){
            System.out.println();
            synchronized (queue){

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.printf("");
                if (queue.getSize() == 10){
                    try {
                        System.out.printf(this.name + " is waiting ");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else {

                    queue.add(count++);
                    System.out.println(this.name + " produced" + count + " queue size: " + queue.getSize());
                    queue.print();
                    queue.notifyAll();

                }

            }

        }

    }

}

class Consumer implements Runnable{

    private Queue queue;
    private String name;

    public Consumer(Queue queue, String name) {
        this.queue = queue;
        this.name = name;
    }

    @Override
    public void run() {

        consume();

    }

    private void consume(){

        while (true){
            System.out.println();
            synchronized (queue){

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (queue.getSize() == 0){
                    try {
                        System.out.printf(this.name + "" + " is waiting ");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                else {

                    System.out.println( " consumed by " + this.name +  " as: " + queue.pop());
                    queue.print();
                    queue.notifyAll();

                }

            }

        }

    }

}