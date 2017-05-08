package com.multithreading.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {

    private static AtomicInteger MY_INT = new AtomicInteger(0);

    public static void main(String[] args) {

        new ChangeListener().start();
        new ChangeMaker().start();

    }

    static class ChangeListener extends Thread {

        @Override
        public void run() {
            int local_value = MY_INT.intValue();
            while ( local_value < 5){
                if( local_value!= MY_INT.intValue()){
                    System.out.println("Got Change for MY_INT : " + MY_INT);
                    local_value= MY_INT.intValue();
                }
            }
        }
    }

    static class ChangeMaker extends Thread{
        @Override
        public void run() {

            int local_value = MY_INT.intValue();
            while (MY_INT.intValue() <5){
                System.out.println("Incrementing MY_INT to {0}" + local_value);
                MY_INT.set(++local_value);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
    }
}