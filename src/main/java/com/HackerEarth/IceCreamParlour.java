package com.HackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IceCreamParlour {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int testCases = Integer.parseInt(line);
        int dollars;
        String[] splitted;

        for (int i = 0; i < testCases; i++){

            line = br.readLine();
            dollars = Integer.parseInt(line);
            br.readLine();
            line = br.readLine();
            splitted = line.split("\\s+");
            int[] costs = new int[splitted.length];

            for (int j = 0; j < splitted.length; j++){
                costs[j] = Integer.parseInt(splitted[j]);
            }
            outerloop:
            for (int j = 0; j < costs.length; j++){
                int k = j+1;
                while (k < costs.length){

                    if (costs[j] + costs[k] == dollars){
                        System.out.println((j+1) + " " + (k+1));
                        break outerloop;
                    }
                    k++;
                }
            }

        }

    }
}