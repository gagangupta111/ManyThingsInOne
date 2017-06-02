package com.HackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingNumbers {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String line = br.readLine();
        String[] splitted = line.split("\\s+");
        int[] N = new int[splitted.length];

        for (int i = 0; i < splitted.length; i++){
            N[i] = Integer.parseInt(splitted[i]);
        }

        br.readLine();
        line = br.readLine();
        splitted = line.split("\\s+");

        int[] M = new int[splitted.length];

        for (int i = 0; i < splitted.length; i++){
            M[i] = Integer.parseInt(splitted[i]);
        }

        Set<Integer> set = new HashSet<Integer>();

        Arrays.sort(N);
        Arrays.sort(M);

        int j = 0;
        for (int i = 0; i < N.length && j < M.length; i++, j++){

            if (N[i] != M[j]){
                i--;
                set.add(M[j]);
            }

        }

        while (j < M.length){
            set.add(M[j]);
            j++;
        }

        Integer[] list = new Integer[set.size()];
        j = 0;
        for (Integer integer : set){
            list[j] = integer;
            j++;
        }

        Arrays.sort(list);

        for (Integer integer : list){
            System.out.print(integer + " ");
        }

    }
}