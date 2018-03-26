package com.multithreading;

public class AbstractInterfaceRunnable {

    public static void main(String[] args){

        System.out.println(" Hello ! ");

    }

}

interface get{

    public int getVariable();

}

interface set{

    public boolean setVariable();

}

interface Print<T>{

    public void print(T t);

}

class printClass implements Print{

    @Override
    public void print(Object o) {

        System.out.println(o.toString());

    }
}

abstract class getSet implements get , set{

    protected static volatile int variable = 0;
    protected boolean flag = false;

    public getSet(boolean flag) {
        this.flag = flag;
    }
}

class getSetImplemented extends getSet implements Runnable{

    public getSetImplemented(boolean flag) {
        super(flag);
    }

    @Override
    public int getVariable() {
        return variable;
    }

    @Override
    public boolean setVariable() {
        variable = variable +1;
        return true;
    }

    @Override
    public void run() {

        if (flag)
        getVariable();
        else setVariable();

    }
}

