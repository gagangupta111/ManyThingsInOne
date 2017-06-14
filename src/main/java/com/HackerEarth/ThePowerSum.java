package com.HackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ThePowerSum {

    public static void main(String[] args) throws Exception{

        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        int pow = Integer.parseInt(br.readLine());
        int max = findMax(X, pow);

        // store powers of numbers in array and then find the number of subsets which sums to X

    }

    public static int findMax(int X, int pow){
        for (int i = 1; i < X; i++){
            if (Math.pow(i, pow) > X){
                return i--;
            }
        }
        return 1;
    }
}