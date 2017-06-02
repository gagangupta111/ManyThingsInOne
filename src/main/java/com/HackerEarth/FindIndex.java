package com.HackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FindIndex {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int V = Integer.parseInt(line);

        line = br.readLine();
        int N = Integer.parseInt(line);

        line = br.readLine();
        String[] ar = line.split("\\s+");

        for (int i = 0; i < ar.length; i++){

            if ( V == Integer.parseInt(ar[i])){
                System.out.println(i);
                break;
            }
        }

    }
}
