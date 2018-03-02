package com.Generic;

public class Test {

    public static void main(String[] args){

        System.out.println(" Hello !");

        Box<Integer> boxInt;


        Box box = new BoxInt(12, 13, 14);
        System.out.println(" Volume : " + box.volume());

        box = new BoxFloat(12.12f, 13.13f, 14.14f);
        System.out.println(" Volume : " + box.volume());

        box = new BoxDouble(12.12d, 13.13d, 14.14d);
        System.out.println(" Volume : " + box.volume());

        int i = 5;
        Object k = i;

        k = 10;
        int j = (int)k;

        System.out.println("" + i + " " + j + " " + k);


    }

}