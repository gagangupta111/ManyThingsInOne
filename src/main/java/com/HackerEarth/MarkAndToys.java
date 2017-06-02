package com.HackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MarkAndToys {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] splitted = line.split("\\s+");
        int N = Integer.parseInt(splitted[0]);
        int K = Integer.parseInt(splitted[1]);
        Integer[] toys = new Integer[N];

        line = br.readLine();
        splitted = line.split("\\s+");

        int i = 0;
        while (i < N) {
            toys[i] = Integer.parseInt(splitted[i]);
            i++;
        }

        Arrays.sort(toys);

        int maxNoOfToys = 0;
        int maxToysPrice = 0;

        for (Integer toy : toys){
            maxToysPrice += toy;
            if (maxToysPrice <= K){
                maxNoOfToys++;
            }else {
                break;
            }
        }

        System.out.println(maxNoOfToys);
    }
}