package com.HackerEarth;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SwapPermutation {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        Integer[] numbers = new Integer[N];
        for (int numbers_i = 0; numbers_i < N; numbers_i++) {
            numbers[numbers_i] = in.nextInt();
        }

        if (K >= N){
            Arrays.sort(numbers, Collections.<Integer>reverseOrder());
        }else if (K >= N/2){

            int Max = Integer.MIN_VALUE;
            int index = 0;
            int max_i = 0;

            while (index < numbers.length && K > 0) {
                Max = Integer.MIN_VALUE;
                for (int i = index; i < numbers.length; i++) {

                    if (Max < numbers[i]) {
                        Max = numbers[i];
                        max_i = i;
                    }
                }
                if (Max != numbers[index]) {
                    int temp = numbers[max_i];
                    numbers[max_i] = numbers[index];
                    numbers[index] = temp;
                    K--;
                }
                index++;
            }

        }{

            int Max = Integer.MIN_VALUE;
            int index = 0;
            int max_i = 0;

            while (index < numbers.length && K > 0) {
                Max = Integer.MIN_VALUE;
                for (int i = index; i < numbers.length; i++) {

                    if (Max < numbers[i]) {
                        Max = numbers[i];
                        max_i = i;
                    }
                }
                if (Max != numbers[index]) {
                    int temp = numbers[max_i];
                    numbers[max_i] = numbers[index];
                    numbers[index] = temp;
                    K--;
                }
                index++;
            }
        }

        for (int x: numbers){
            System.out.print( x + " ");
        }

    }
}