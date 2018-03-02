package com.multithreading;

import java.lang.reflect.Constructor;

public class Test {

    public static void main(String[] args) {

        EagerInitializedSingleton instanceOne = EagerInitializedSingleton.getInstance();
        EagerInitializedSingleton instanceTwo = null;

        try {

            Constructor[] constructors = EagerInitializedSingleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                //Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (EagerInitializedSingleton) constructor.newInstance();
                break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());

    }

}

class Singleton{

    private Singleton(){}

    private static Singleton singleton = null;

    public Singleton getInstance(){

        if (singleton == null) {

            synchronized (Singleton.class) {

                if (singleton == null) {
                    singleton = new Singleton();
                }

            }
        }

        return singleton;

    }

}
