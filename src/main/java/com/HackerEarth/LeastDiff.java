package com.HackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LeastDiff {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);

        if (N == 1){
            System.out.println(0);
        }

        line = br.readLine();
        String[] splitted = line.split("\\s+");
        int[] array = new int[N];

        for (int i = 0; i<N; i++){
            array[i] = Integer.parseInt(splitted[i]);
        }

        Arrays.sort(array);

        int min = Integer.MAX_VALUE;

        for (int i = 1; i<N; i++){
           if(min > Math.abs(array[i] - array[i-1])){
               min = Math.abs(array[i] - array[i-1]);
           }
        }

        System.out.println(min);

    }
}