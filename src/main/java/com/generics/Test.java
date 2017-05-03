package com.generics;

import java.util.LinkedList;
import java.util.List;

public class Test {

    public static void main(String[] args){

        System.out.println(" Hello !");

        List<String> strings = new LinkedList<String>();
        strings.add("a");
        List<?> list = strings;

        List<Integer> stringList = (List<Integer>) list;

        for (Integer a: stringList){

            System.out.println(a);

        }
    }
}
