package com.HackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayAndSimpleQueries {

    public static void main(String[] args) throws IOException {

        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        String line  = br.readLine();
        String[] split  = line.split("\\s+");
        int K = Integer.parseInt(split[1]);

        line  = br.readLine();
        split  = line.split("\\s+");

        int[] array = new int[split.length];

        for (int i = 0; i < split.length; i++){

            array[i] = Integer.parseInt(split[i]);

        }

        for (int i = 0; i < K; i++){

            line  = br.readLine();
            split  = line.split("\\s+");
            int flag = Integer.parseInt(split[0]);
            if (flag == 1){
                before(array, Integer.parseInt(split[1]) -1 , Integer.parseInt(split[2]) -1);
            }else {
                after(array, Integer.parseInt(split[1]) -1, Integer.parseInt(split[2]) -1);
            }

        }

        System.out.println(Math.abs(array[array.length - 1] - array[0]));
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }

    }

    private static void before(int[] array, int i, int j){

        if (i == 0){
            return;
        }
        int[] subArray = new int[j - i + 1];
        for (int index = i, start = 0; index <= j; index++){
            subArray[start] = array[index];
            start++;
        }

        i--;
        while (i >= 0){
            array[j] = array[i];
            j--;
            i--;
        }

        for (int index = 0; index < subArray.length; index++){
            array[index] = subArray[index];
        }

    }

    private static void after(int[] array, int i, int j){

        if (j == array.length - 1){
            return;
        }

        int[] subArray = new int[j - i + 1];
        for (int index = i, start = 0; index <= j; index++){
            subArray[start] = array[index];
            start++;
        }

        j++;
        while (j < array.length){
            array[i] = array[j];
            j++;
            i++;
        }

        for (int index = 0; index < subArray.length; index++, i++){
            array[i] = subArray[index];
        }

    }

}
