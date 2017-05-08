package com.multithreading.atomic;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTestBoolean {

    private static AtomicBoolean MY_BOOL = new AtomicBoolean(true);

    public static void main(String[] args) {

        new ChangeListener().start();
        new ChangeMaker().start();

    }

    static class ChangeListener extends Thread {

        @Override
        public void run() {

            boolean local = MY_BOOL.get();
            while ( local){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(" false!");
                local = MY_BOOL.get();
            }

        }
    }

    static class ChangeMaker extends Thread{
        @Override
        public void run() {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            MY_BOOL.set(false);
        }
    }
}