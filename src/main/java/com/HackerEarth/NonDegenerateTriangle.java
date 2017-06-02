package com.HackerEarth;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class NonDegenerateTriangle {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[] calories = new Integer[n];

        for (int calories_i = 0; calories_i < n; calories_i++) {
            calories[calories_i] = in.nextInt();
        }

        Arrays.sort(calories, Collections.reverseOrder());

        int a = 0, b = 0, c = 0;
        boolean flag  = false;

        for (int i = 2; i < calories.length; i++){

            a = calories[i].intValue();
            b = calories[i-1].intValue();
            c = calories[i-2].intValue();

            if (a+b <= c || a+c <= b || b+c <= a){
                continue;
            }else{
                System.out.println(a + " " + b + " " + c);
                flag = true;
                break;
            }

        }

        if (!flag)
            System.out.println(-1);

    }
}
