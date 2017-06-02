package com.HackerEarth;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CupCakes {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[] calories = new Integer[n];

        for(int calories_i=0; calories_i < n; calories_i++){
            calories[calories_i] = in.nextInt();
        }

        Arrays.sort(calories, Collections.reverseOrder());
        long miles = 0;

        for (int i = 0; i < calories.length; i++){

            miles += Math.pow(2, i)*calories[i];

        }

        System.out.println(miles);



    }
}
