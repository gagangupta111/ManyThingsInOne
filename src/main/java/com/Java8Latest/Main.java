package com.Java8Latest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;

public class Main {

    public static void main(String[] args){

        // for each
        List<Integer> integerList = new ArrayList<>();
        integerList.add(11);
        integerList.add(12);
        integerList.add(13);
        integerList.add(14);

        integerList.forEach(integer -> {
            System.out.print(integer + " ");
        });

        // default and static methods
        Class1 class1 = new Class1();
        System.out.println(Interface1.returnStringStatic("String"));
        System.out.println(Interface2.returnStringStatic("String"));

        System.out.println(class1.returnint(1));
        System.out.println(class1.returnIntDefault(1));
        System.out.println(class1.returnIntInterface1(1));
        System.out.println(class1.returnIntInterface2(1));
        System.out.println(class1.returnString("String"));

        // APIs
        Iterator<Integer> iterator = integerList.iterator();
        System.out.println("first: " + iterator.next());
        iterator.forEachRemaining(integer -> {
            System.out.println(integer);
        });

        Spliterator<Integer> spliterator = integerList.spliterator();
        System.out.println(" Spliterator implementation. ");

        Spliterator<Integer> spliterator1 = spliterator.trySplit();

        spliterator.forEachRemaining(integer -> {
            System.out.println("integer " + integer);
        });



    }

}

@FunctionalInterface
interface Interface1{

    int returnint(int i);

    default int returnIntInterface1(int i){
        return 10;
    }

    default int returnIntDefault(int i){
        return i + 1;
    }

    default String returnString(String s){
        return s + "Interface1";
    }

    static String returnStringStatic(String s){
        return s + "Interface1";
    }
}

@FunctionalInterface
interface Interface2{

    int returnint(int i);

    default int returnIntInterface2(int i){
        return 11;
    }

    default int returnIntDefault(int i){
        return i + 2;
    }

    default String returnString(String s){
        return s + "Interface2";
    }

    static String returnStringStatic(String s){
        return s + "Interface2";
    }
}

class Class1 implements Interface1, Interface2{

    @Override
    public int returnint(int i) {
        return i + 3;
    }

    public int returnIntDefault(int i){
        return i + 3;
    }

    public String returnString(String s){
        return s + "Class1";
    }

}
