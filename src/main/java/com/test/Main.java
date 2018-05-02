package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args){

        System.out.println(" Hello! ");
        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(13);
        list = Collections.unmodifiableList(list);

        Immutable immutable = new Immutable(12, "string", list);
        List<Integer> newList = immutable.getList();

        for (Integer integer : immutable.getList()){

            System.out.println(integer);

        }

        A a = new Implemented();
        a.show();

    }

}

class Implemented implements C{

    @Override
    public void show() {
        System.out.println(" Show Implemented! ");
    }

}

interface A{

    public void show();

}

interface B{

    public void show();

}

interface C extends A, B{

}
