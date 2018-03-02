package com.multithreading;

public final class AlternateNumberPassing {

    public static void main(String[] args){

        Number[] array = {

                new Number(2,false),
                new Number(3,false),
                new Number(4,false),
                new Number(5,false),
                new Number(6,false),
                new Number(7,false),
                new Number(888,false),
                new Number(99,false),
                new Number(1000,false),
                new Number(8777,false)

        };

        Thread thread1 = new Thread(new SharingThread(array, 0), "even");
        Thread thread2 = new Thread(new SharingThread(array, 1), "odd");

        thread1.start();
        thread2.start();

    }

}

class Number{

    public int number;
    public boolean flag;

    public Number(int number, boolean flag) {

        this.number = number;
        this.flag = flag;

    }

}

final class SharingThread implements Runnable{

    private final Number[] array;
    private volatile int index;

    public SharingThread(Number[] array, int index) {

        this.array = array;
        this.index = index;

    }

    @Override
    public void run() {

        while (true) {

            synchronized (array) {

                if (index >= array.length) {

                    System.out.println(Thread.currentThread().getName() + " done " );
                    return;

                }

                while (index - 1 >= 0 && array[index - 1].flag == false) {

                    try {

                        array.wait();

                    } catch (InterruptedException e) {

                        e.printStackTrace();

                    }
                }

                try {

                    Thread.sleep(1000);

                } catch (InterruptedException e) {

                    e.printStackTrace();

                }

                Number number = array[index];
                System.out.println(Thread.currentThread().getName() + " " + number.number);
                number.flag = true;
                index = index+2;
                array.notify();

            }

        }
    }

}
