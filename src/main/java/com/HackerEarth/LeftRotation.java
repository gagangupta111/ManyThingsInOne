package com.HackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeftRotation {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line  = bufferedReader.readLine();

        String[] splitted  = line.split("\\s+");
        int n = Integer.parseInt(splitted[0]);
        int d = Integer.parseInt(splitted[1]);
        line  = bufferedReader.readLine();
        splitted  = line.split("\\s+");

        int[] array = new int[splitted.length];
        int[] newArray = new int[splitted.length];

        for (int  i = 0; i < splitted.length; i++){
            array[i] = Integer.parseInt(splitted[i]);
        }

        if (d >= n){
            newArray = array;
        }

        for (int i = d,j = 0; ; i++){
            if (i == array.length){
                i = 0;
            }
            newArray[j++] = array[i];
            if (j == newArray.length)break;
        }

        for (int  i = 0; i < newArray.length; i++){
            System.out.print(newArray[i] + " ");
        }



    }
}
