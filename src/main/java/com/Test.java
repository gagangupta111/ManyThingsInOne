package com;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Test
{

    public static void swap(FinalTesting one, FinalTesting two){

        System.out.println(one);
        System.out.println(two);
        System.out.println();

        int[] arr = {1,2};
        int s = arr.length;

        FinalTesting temp = one;
        one = two;
        two = temp;

        System.out.println(one);
        System.out.println(two);
        System.out.println();

        System.out.println("Print" + kangaroo(0,2,5,3));

    }

    static int migratoryBirds(int n, int[] ar) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int i  = 0; i < n; i++){

            Integer value = map.get(ar[i]);
            if (value == null){
                map.put(ar[i], 1);
            }else {
                map.put(ar[i], value+1);
            }

        }

        int key = -1;
        int value = -1;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){

            if (entry.getValue().intValue() > value){

                value = entry.getValue().intValue();
                key = entry.getKey().intValue();

            }
        }

        return key;

    }

    static String kangaroo(int x1, int v1, int x2, int v2) {

        int distance = Integer.MAX_VALUE;
        int newDistance = Math.abs(x1 - x2);

        while ( newDistance < distance ){

            if (newDistance == 0){
                return "YES";
            }

            distance = newDistance;
            newDistance = Math.abs((x1 = x1 + v1) - (x2 = x2 + v2));

        }

        return "NO";

    }


    static int countDuplicates(int[] numbers) {
        /*
         * Write your code here.
         */

        Map<Integer, Integer> map  = new HashMap<>();


        for (int i : numbers){
            if (map.get(i) == null){
                map.put(i, 1);
            }else {
                map.put(i, map.get(i) + 1);
            }
        }

        int count = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){

            if (entry.getValue() > 1){
                count++;
            }

        }

        return count;

    }

    public static void main(String args[])
    {

        System.out.println(getTrailing0InFactorial(29));

        if ( Math.abs(5-1) > Math.abs(4-3) ){
            System.out.println();
        }

    }

    public static int getTrailing0InFactorial(int num) {
        if(num<0)
            return -1;

        int count = 0;
        for (int i = 5; (num/i) > 0; i=i*5) {
            count = count + num/i;
        }
        return count;
    }

}

final class FinalTesting{

    public int integer;
    public final List<Integer> list;
    public final Map<String, String> map;

    public FinalTesting(List<Integer> list, Map<String, String> map) {
        this.list = list;
        this.map = map;
        integer = 100;
    }

    public int getInteger() {
        return integer;
    }

    public List<Integer> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "FinalTesting{" +
                "integer=" + integer +
                ", list=" + list +
                ", map=" + map +
                '}';
    }
}


