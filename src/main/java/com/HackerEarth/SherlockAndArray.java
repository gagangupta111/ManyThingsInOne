package com.HackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SherlockAndArray {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int testCases = Integer.parseInt(line);
        String[] splitted ;

        testCasesLoop:
        for (int i = 0; i < testCases; i++) {

            line = br.readLine();
            int size = Integer.parseInt(line);

            line = br.readLine();
            if (size < 2){
                System.out.println("YES");
                continue;
            }

            splitted = line.split("\\s+");
            int[] array = new int[splitted.length];

            for (int j = 0; j < splitted.length; j++){
                array[j] = Integer.parseInt(splitted[j]);
            }

            int sumLeft = 0;
            int sumRight = 0;

            int j = 0;
            while (j < array.length){
                sumRight += array[j];
                j++;
            }

            j = 0;
            sumRight -= array[0];

            while ( j < array.length){
                if (sumLeft == sumRight){
                    System.out.println("YES");
                    continue testCasesLoop;
                }
                sumLeft += array[j];
                if (j+1 < array.length) {
                    sumRight -= array[j + 1];
                }
                j++;
            }
            System.out.println("NO");
        }
    }
}