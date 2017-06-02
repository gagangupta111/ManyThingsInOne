package com.HackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SaveMoney {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int noOfStudents = Integer.parseInt(line);
        int[] students  = new int[noOfStudents];
        int index = 0, candies = 1, t2 = 0;
        int t1 = Integer.parseInt(br.readLine());

        while (index < noOfStudents-1){

            t2 = Integer.parseInt(br.readLine());
            if (t2 > t1){
                candies+= 2;
            }else{
                candies++;
            }
            t1 = t2;
            index++;
        }
        System.out.println(candies);
    }
}