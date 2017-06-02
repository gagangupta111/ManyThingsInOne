package com.HackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class GreedyFlorist {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] splitted = line.split("\\s+");
        int N = Integer.parseInt(splitted[0]);
        int K = Integer.parseInt(splitted[1]);
        Integer[] flowers = new Integer[N];

        line = br.readLine();
        splitted = line.split("\\s+");

        int i = 0;
        while (i < N) {
            flowers[i] = Integer.parseInt(splitted[i]);
            i++;
        }

        Arrays.sort(flowers, Collections.<Integer>reverseOrder());
        int partitions = ((int)Math.ceil(N/K))+1;
        Integer[][] friendsSpace = new Integer[K][partitions];

        int cost = 0;

        int index = 0;
        for (int j = 0; j < partitions; j++){
            for (int k = 0; k < K; k++) {
                if (index >= flowers.length){
                    break;
                }
                cost += (j+1)*flowers[index];
                index++;
            }
        }

        System.out.println(cost);

    }
}
