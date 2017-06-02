package com.HackerEarth;

import java.util.Scanner;

public class TestCount {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int _arr_rows = 0;
        int _arr_cols = 0;
        _arr_rows = Integer.parseInt(in.nextLine().trim());
        _arr_cols = Integer.parseInt(in.nextLine().trim());

        int[][] _arr = new int[_arr_rows][_arr_cols];
        for(int _arr_i=0; _arr_i<_arr_rows; _arr_i++) {
            for(int _arr_j=0; _arr_j<_arr_cols; _arr_j++) {
                _arr[_arr_i][_arr_j] = in.nextInt();

            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        countNumbers(_arr);

    }

    static void countNumbers(int[][] arr) {

        for(int i = 0; i < arr.length; i++){
            printNumbers(arr[i][0], arr[i][1]);
        }

    }

    static void printNumbers(int x, int y){

        int count = 0;
        while(x<=y){
            if(hasDistinctDigits(x))count++;
            x++;
        }
        System.out.println(count);
    }

    static boolean hasDistinctDigits(int number) {

        int numMask = 0;
        int numDigits = (int) Math.ceil(Math.log10(number+1));
        for (int digitIdx = 0; digitIdx < numDigits; digitIdx++) {
            int curDigit = (int)(number / Math.pow(10,digitIdx)) % 10;
            int digitMask = (int)Math.pow(2, curDigit);
            if ((numMask & digitMask) > 0) return false;
            numMask = numMask | digitMask;
        }
        return true;
    }

}