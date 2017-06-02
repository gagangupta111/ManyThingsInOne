package com.HackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxMin {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);

        line = br.readLine();
        int K = Integer.parseInt(line);

        Integer[] numbers = new Integer[N];

        int i = 0;
        while (i < N) {
            numbers[i] = Integer.parseInt(br.readLine());
            i++;
        }

        Arrays.sort(numbers);
        i = 0;
        int min = Integer.MAX_VALUE;

        while (i < N && i+K-1 < N) {
            if ((numbers[i+K-1] - numbers[i]) < min){
                min = (numbers[i+K-1] - numbers[i]);
            }
            i++;
        }

        System.out.println(min);

    }
}
