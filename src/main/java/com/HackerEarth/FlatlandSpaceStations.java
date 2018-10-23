package com.HackerEarth;

import java.util.Arrays;

public class FlatlandSpaceStations {

    public static void main(String[] args){

        int [] array  = {68, 81, 46, 54, 30, 11, 19, 23, 22, 12, 38, 91, 48, 75, 26, 86, 29, 83, 62};
        System.out.println(flatlandSpaceStations(95, array));

    }

    static int flatlandSpaceStations(int n, int[] c) {

        int sd = Integer.MIN_VALUE;
        int prev = 0;
        int now = 0;
        int j = 0;
        Arrays.sort(c);
        for (now = 0; now < n; now++){

            if ( now == c[j]){
                if ((now-prev) > sd){
                    sd = now-prev;
                }
                prev = now;
                if (j < c.length-1){
                    j++;
                }
            }

        }

        if ((now-prev-1) > sd){
            sd = now-prev-1;
            return sd;
        }

        return sd/2;

    }

}
