package com.HackerEarth;

import java.util.Arrays;

public class FlatlandSpaceStations {

    public static void main(String[] args){

        int [] array  = {0,6};
        System.out.println(flatlandSpaceStations(7, array));

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
                }else return sd/2;
            }

        }

        return sd/2;

    }

}
