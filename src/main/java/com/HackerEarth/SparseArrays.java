package com.HackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SparseArrays {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line  = bufferedReader.readLine();

        int n = Integer.parseInt(line);
        String[] array = new String[n];

        for (int i = 0; i < n; i++){

            line  = bufferedReader.readLine();
            array[i] = line;

        }

        line  = bufferedReader.readLine();
        int k = Integer.parseInt(line);

        for (int i = 0; i < k; i++){
            line  = bufferedReader.readLine();
            int count  = 0;
            for (int j = 0; j < n; j++){
                if (line.equals(array[j])){
                    count++;
                }
            }
            System.out.println(count);
        }

    }
}
