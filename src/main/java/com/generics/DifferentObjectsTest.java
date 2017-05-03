package com.generics;

public class DifferentObjectsTest {

    public static < E > void printObject( E object ) {

        if (object.getClass() == Class1.class){
            Class1 class1 = (Class1)object;
            class1.print();
        }

        if (object.getClass() == Class2.class){
            Class2 class2 = (Class2)object;
            class2.print();
        }

    }

    public static void main(String args[]) {

        Class1 class1 = new Class1();
        Class2 class2 = new Class2();

        printObject(class1);
        printObject(class2);



    }
}