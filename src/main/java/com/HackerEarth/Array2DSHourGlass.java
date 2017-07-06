package com.HackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Array2DSHourGlass {

    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int[][] array = new int[6][6];

        for (int i = 0; i < 6; i++){

            String line  = br.readLine();
            String[] split = line.split("\\s+");
            for (int j = 0; j < 6; j++){
                array[i][j] = Integer.parseInt(split[j]);
            }

        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < 5; i++){
            for (int j = 1; j < 5; j++){
                int sum = 0;
                sum += array[i-1][j-1] + array[i-1][j] + array[i-1][j+1]
                        + array[i][j] + array[i+1][j-1] + array[i+1][j]
                        + array[i+1][j+1];
                if (sum > max){
                    max = sum;
                }
            }
        }

        System.out.println(max);
    }
}