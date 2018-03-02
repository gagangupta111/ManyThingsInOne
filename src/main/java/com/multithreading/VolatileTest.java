package com.multithreading;

// Here listener thread is using MY_INT. This thread is checking if the value of My_INT has changed or not
// this listener thread does not detect any change, because it keeps the old copy in its thread cache of the same variable.
// after making it volatile it does not keep cache in its local but instead it does go directly to one common variable.

public class VolatileTest {

    private static volatile int MY_INT = 0;

    public static void main(String[] args) {

        new ChangeListener().start();
        new ChangeMaker().start();

    }

    static class ChangeListener extends Thread {

        @Override
        public void run() {
            int local_value = MY_INT;
            while ( local_value < 5){
                if( local_value!= MY_INT){
                    System.out.println("Got Change for MY_INT : " + MY_INT);
                    local_value= MY_INT;
                }
            }
        }
    }

    static class ChangeMaker extends Thread{
        @Override
        public void run() {

            int local_value = MY_INT;
            while (MY_INT <5){
                System.out.println("Incrementing MY_INT to {0}" + local_value);
                MY_INT = ++local_value;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
    }
}
