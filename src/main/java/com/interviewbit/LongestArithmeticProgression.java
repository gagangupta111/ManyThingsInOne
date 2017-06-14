package com.interviewbit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestArithmeticProgression {

    public static void main(String[] args){

        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++){

            list.add(i);

        }

        for (int i = 15; i < 35; i = i+3){

            list.add(i);

        }

        for (Integer integer: list){
            System.out.print(integer + " ");
        }

        LongestArithmeticProgression progression = new LongestArithmeticProgression();
        System.out.println();
        System.out.println(progression.solve(list));


    }

    public int solve(final List<Integer> A) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        if (A == null || A.size() == 0){
            return 0;
        }

        int[] array = new int[A.size() - 1];
        for (int i = 0; i < array.length; i++){
            array[i] = A.get(i+1) - A.get(i);
        }

        int selected = Integer.MIN_VALUE;
        int count = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++){

          if (map.get(array[i]) == null){
              map.put(array[i], 1);
          }else {
              map.put(array[i], map.get(array[i]) + 1);
          }

        }
        int maxValue = Integer.MIN_VALUE;
        for (Integer integer: map.values()){
            if (integer > maxValue)maxValue = integer;
        }

        return (maxValue+1)>1?maxValue+1:1;
    }
}

abstract class A{

}