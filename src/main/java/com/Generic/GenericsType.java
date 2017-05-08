package com.Generic;

import java.util.ArrayList;
import java.util.List;

public class GenericsType<T> {

    private T t;

    public T get(){
        return this.t;
    }

    public void set(T t1){
        this.t=t1;
    }

    public static void main(String args[]){

        GenericsType<String> type = new GenericsType<String>();
        type.set("Pankaj"); //valid

        GenericsType type1 = new GenericsType(); //raw type
        type1.set("Pankaj"); //valid
        type1.set(10); //valid and autoboxing support

        boolean b = isEqual(type, type1);
        System.out.println(b);

        List<String> list = new ArrayList<String>();

        list.add("gagan");

        List<?> list1 = new ArrayList<String>();
        list1 = new ArrayList<Object>();
        list1 = new ArrayList<Integer>();


    }

    public static <T> boolean isEqual(GenericsType<T> g1, GenericsType<T> g2){

        return g1.get().equals(g2.get());

    }

}