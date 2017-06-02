package com.HackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AlgorithmicCrush {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line  = br.readLine();
        String[] splitted = line.split("\\s+");

        int[] NM = new int[splitted.length];

        int i = 0;
        while (i<splitted.length){
            NM[i] = Integer.parseInt(splitted[i++]);
        }

        long[] N = new long[NM[0]];
        i = 0;
        while (i<N.length){
            N[i] = 0;
            i++;
        }

        i = 0;
        long max  = 0;

        int max_a = 0;
        int max_b = N.length - 1;

        while (i<NM[1]){
            line = br.readLine();
            splitted = line.split("\\s+");

            int a = Integer.parseInt(splitted[0]);
            int b = Integer.parseInt(splitted[1]);
            int k = Integer.parseInt(splitted[2]);

            int j = a;

            while (j<=b){
                N[j-1] += k;
                j++;
            }


                if (N[a-1] > N[max_a]){
                    max_a = a-1;
                }
                if (N[b-1] > N[max_b]){
                    max_b = b-1;
                }


            i++;

        }

       /* i = 0;
        long max  = 0;
        while (i<N.length){

            if (max < N[i]){
                max = N[i];
            }

            i++;

        }*/

        System.out.println(N[max_a]>N[max_b]?N[max_a]:N[max_b]);
    }
}