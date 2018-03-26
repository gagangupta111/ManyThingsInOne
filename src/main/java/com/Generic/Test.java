package com.Generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test {

    public static void main(String[] args){

        System.out.println(" Hello !");

        HashMap hashMap = new HashMap();
        hashMap.get(null);
        hashMap.put(null, null);

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

        List<B2> list = new ArrayList<>();

        check(list);

    }

    public static void check(List<? super C2> list ){

        System.out.println();

    }

}

interface A1{}
interface A2{}
interface A3{}
interface A4{}

interface B1 extends A1{}
interface B2 extends A1,A2{}
interface B3 extends A3,A4{}
interface B4 extends A4{}

interface C1 extends B2{}
interface C2 extends B2,B3{}
interface C3 extends B3{}

interface D1 extends C1,C2{}
interface D2 extends C2{}

interface E1 extends D1{}
interface E2 extends D1{}
interface E3 extends D2{}
interface E4 extends D2{}