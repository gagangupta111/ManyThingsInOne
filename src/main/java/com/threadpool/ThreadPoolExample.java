package com.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPoolExample {

    public static void main(String[] args){

        System.out.println(" Hello! ");
        Queue<Task> queue = new Queue<>(4);
        for (int i = 0; i < 5; i++) {

            Thread thread1 = new Thread(new WorkerThread(queue, i));
            thread1.start();

        }

        for (int i = 0; i < 20; i++) {

            Task task = new Task(i);
            queue.add(task);

        }

    }

}

class Queue<Task>{

    private int capacity;
    private List<Task> list;

    public Queue(int capacity) {
        this.capacity = capacity;
        list = new ArrayList<>(capacity);
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public boolean isFull(){

        if (list.isEmpty()){
            return false;
        }

        if (list.size() < capacity){
            return false;
        }

        return true;

    }

    public boolean add(Task task){

        if (isFull()){
            return false;
        }

        synchronized (this){

            list.add(task);
            this.notifyAll();

        }

        return true;

    }

    public Task fetch(){

        Task task = null;
        if (isEmpty()){
            return task;
        }

        task = list.get(0);
        list.remove(task);
        return task;

    }

}

class WorkerThread implements Runnable{

    private Queue<Task> queue;
    private int id;

    public WorkerThread(Queue<Task> queue, int id) {
        this.queue = queue;
        this.id = id;
    }

    @Override
    public void run() {
        Task task;
        while (true) {
            synchronized (queue) {

                while (queue.isEmpty()) {

                    try {

                        queue.wait();

                    } catch (InterruptedException e) {

                        e.printStackTrace();

                    }
                }

                task= queue.fetch();
                task.execute(id);
                queue.notifyAll();
            }

        }
    }

}

class Task{

    private int id;

    public Task(int id) {

        this.id = id;

    }

    public void execute(int wID){

        System.out.println(" Task " + id + " is executed by worker " + wID);

    }

}
