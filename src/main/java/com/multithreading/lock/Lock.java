package com.multithreading.lock;

public class Lock{

    boolean isLocked = false;
    Thread  lockedBy = null;
    int lockedResourceCount = 0;
    public int total_threads = 0;

    public void lock()
            throws InterruptedException{

        Thread callingThread = Thread.currentThread();

        while(isLocked && lockedBy != callingThread && total_threads > 5) {
            wait();
        }

        isLocked = true;
        lockedResourceCount++;
        lockedBy = callingThread;
        total_threads++;

    }

    public synchronized void unlock(){

        if(Thread.currentThread() == this.lockedBy){

            lockedResourceCount--;
            total_threads--;

            if(lockedResourceCount == 0){
                isLocked = false;
                notify();
            }

        }
    }
}