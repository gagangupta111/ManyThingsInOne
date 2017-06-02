package com.HackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FindDigits {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int testCases = Integer.parseInt(line);
        String[] splitted;

        for (int i = 0; i < testCases; i++){

            line = br.readLine();
            int number = Integer.parseInt(line);
            splitted = line.split("");
            int count  = 0;

            for (String s: splitted){
                int num = Integer.parseInt(s);
                if (num != 0 && number%num == 0){
                    count++;
                }
            }

            System.out.println(count);

        }
    }
}