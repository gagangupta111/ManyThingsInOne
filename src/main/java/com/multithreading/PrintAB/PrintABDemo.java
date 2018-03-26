package com.multithreading.PrintAB;

public class PrintABDemo {

    public static void main(String[] args){

        System.out.println(" Hello! ");

        PrintResource printResource = new PrintResource();
        PrintABClass a = new PrintABClass("AAAA1", printResource);
        PrintABClass b = new PrintABClass("BBBB1", printResource);
        PrintABClass c = new PrintABClass("AAAA2", printResource);
        PrintABClass d = new PrintABClass("BBBB2", printResource);
        PrintABClass e = new PrintABClass("AAAA3", printResource);
        PrintABClass f = new PrintABClass("BBBB3", printResource);
        PrintABClass g = new PrintABClass("AAAA4", printResource);
        PrintABClass h = new PrintABClass("BBBB4", printResource);
        PrintABClass i = new PrintABClass("AAAA5", printResource);
        PrintABClass j = new PrintABClass("BBBB5", printResource);

        Thread one = new Thread(a);
        Thread two = new Thread(b);
        Thread three = new Thread(c);
        Thread four = new Thread(d);
        Thread five = new Thread(e);
        Thread six = new Thread(f);
        Thread seven = new Thread(g);
        Thread eight = new Thread(h);
        Thread nine = new Thread(i);
        Thread ten = new Thread(j);

        one.start();
        two.start();
        three.start();
        four.start();
        five.start();
        six.start();
        seven.start();
        eight.start();
        nine.start();
        ten.start();

    }

}

class PrintResource<T>{

    public void print(T o){

        System.out.println(" PrintResource " + o.toString());

    }

}

class PrintABClass implements Runnable{

    protected String alphabet;
    private static volatile boolean flag = false;
    private PrintResource printResource = null;

    public PrintABClass(String alphabet, PrintResource printResource) {
        this.alphabet = alphabet;
        this.printResource = printResource;
    }

    @Override
    public void run() {

        while (true){
            System.out.printf("");
            synchronized (printResource) {

                // to print A, flag must be true. and to print B flag must be false.
                if (alphabet.contains("AAAA") && flag == false){

                    printResource.print(alphabet);
                    flag = true;
                    printResource.notify();


                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }

                if (alphabet.contains("BBBB") && flag == true){

                    printResource.print(alphabet);
                    flag = false;
                    printResource.notify();


                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }

                try {
                    printResource.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    }

}
