package com.HackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArraysDS {

    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String line  = br.readLine();

        int N = Integer.parseInt(line);
        line  = br.readLine();
        String[] split = line.split("\\s+");

        for (int i = split.length - 1; i >= 0; i--){
            System.out.print(Integer.parseInt(split[i]) + " ");
        }

    }

}
