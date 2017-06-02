package com.HackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PriyankaAndToys {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);

        line = br.readLine();
        String[] splitted = line.split("\\s+");

        Integer[] toys  = new Integer[N];

        int i = 0;
        while (i < N) {
            toys[i] = Integer.parseInt(splitted[i]);
            i++;
        }

        Arrays.sort(toys);
        int toysBought = 0;
        int weight = Integer.MIN_VALUE;

        for (Integer toy : toys){

            if (toy > weight+4){
                toysBought++;
                weight = toy;
            }
        }

        System.out.println(toysBought);

    }
}