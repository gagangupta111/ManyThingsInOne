package com.HackerEarth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LuckBalance2 {

    public static void main(String[] args){

        System.out.println("");
        int k = 2;
        int[][] contests = {{5,1}, {2,1}, {1,1}, {8,1}, {10,0}, {5,0}};

        System.out.println(luckBalance(k, contests));

    }

    static int luckBalance(int k, int[][] contests) {

        List<Integer> lost = new ArrayList<>();
        List<Integer> tbd = new ArrayList<>();
        for (int[] pair: contests){
            if (pair[1] == 1){
                tbd.add(pair[0]);
            }else {
                lost.add(pair[0]);
            }
        }

        Collections.sort(tbd);
        int minus = 0;
        if (k < tbd.size()) {
            int win = tbd.size() - k;
            for (int i = 0; i < win; i++){
                minus -= tbd.get(i);
            }
            for (int i = win; i < tbd.size(); i++){
                lost.add(tbd.get(i));
            }
        }else {
            for (Integer i : tbd){
                lost.add(i);
            }
        }

        int sum = 0;
        for (Integer integer : lost){
            sum += integer;
        }

        return sum + minus;
    }

}
