package com.HackerEarth;

import java.util.ArrayList;
import java.util.List;

public class CutTheSticks {

    public static void main(String[] args){

        int[] array = {5, 4, 4, 2, 2, 8};
        array = cutTheSticks(array);
        System.out.println(" Hello! ");

    }

    static int[] cutTheSticks(int[] arr) {

        int min = findMinimum(arr);
        List<Integer> list = new ArrayList<>();

        for (int i : arr){

            int ele = i - min;
            if (ele != 0){
                list.add(ele);
            }

        }

        return  list.stream().mapToInt(i->i).toArray();

    }

    static int findMinimum(int[] arr) {

        int min = Integer.MAX_VALUE;
        for (int i: arr){

            if (i < min){
                min = i;
            }

        }

        return min;

    }

}
