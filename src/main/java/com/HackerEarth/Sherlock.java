package com.HackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sherlock {

    private static int index = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int testCases = Integer.parseInt(line);

        Integer[] B;
        String[] splitted;
        int max = 0;

        for (int i = 0; i < testCases; i++) {

            max = 0;
            line = br.readLine();
            B = new Integer[Integer.parseInt(line)];

            line = br.readLine();
            splitted = line.split("\\s+");

            int j = 1;
            while (j <= splitted.length) {

                max += (Integer.parseInt(splitted[j])) - (Integer.parseInt(splitted[j-1]));
                j++;

            }

            System.out.println(max);

        }

    }
}