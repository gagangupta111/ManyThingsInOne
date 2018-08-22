package com.HackerEarth;

import java.util.Arrays;

public class ElectronicsShop {

    public static void main(String[] args){

        int[] keyboards = {4,8,3,25};
        int[] drives = {2,32,4};

        System.out.println(getMoneySpent(keyboards, drives, 10));

    }

    static int getMoneySpent(int[] keyboards, int[] drives, int b) {

        int highestPrice = -1;

        Arrays.sort(keyboards);
        Arrays.sort(drives);

        for (int key : keyboards){

            for (int drive : drives){

                if ( (key + drive) <= b && (key + drive) > highestPrice ){

                    highestPrice = key + drive;

                }

            }

        }

        return highestPrice;
    }

}
