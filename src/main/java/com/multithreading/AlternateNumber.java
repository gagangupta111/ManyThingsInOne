package com.multithreading;

class Printer
{
    public void send(int number, String message)
    {
        System.out.println("Sending\t"  + number + " from " + message);
        try
        {
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            System.out.println("Thread  interrupted.");
        }

        System.out.println("\n" + number + "Sent" + " from " + message);

    }
}

class ThreadedSend extends Thread
{
    private int[] array;
    private boolean evenFlag = false;
    private int index = 0;
    Printer sender;

    ThreadedSend(Printer obj, boolean flag, int[] arr)
    {
        sender = obj;
        evenFlag = flag;
        array = arr;
    }

    public void run()
    {

        synchronized(sender)
        {
            if (evenFlag) {
                for (int i = 0; i < array.length; i = i + 2) {

                    sender.send(array[i], " even ");

                }
            }
            else {
                for (int i = 1; i < array.length; i = i + 2) {

                    sender.send(array[i], " odd ");

                }
            }
        }
    }
}



class AlternateNumber
{

    public static void main(String args[])
    {

        Printer snd = new Printer();
        int[] array = {2,3,4,5,6,7,8,9,10,11};
        ThreadedSend S1 =
                new ThreadedSend( snd, true, array);
        ThreadedSend S2 =
                new ThreadedSend( snd, false, array);

        S1.start();
        S2.start();

        try
        {
            S1.join();
            S2.join();
        }
        catch(Exception e)
        {
            System.out.println("Interrupted");
        }

    }

}