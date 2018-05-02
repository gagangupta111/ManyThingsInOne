package com.HackerEarth;

public class Kangaroo {

    static String kangaroo(int x1, int v1, int x2, int v2) {

        int distance = Integer.MAX_VALUE;
        int newDistance = Math.abs(x1 - x2);

        while ( newDistance < distance ){

            if (newDistance == 0){
                return "YES";
            }

            distance = newDistance;
            newDistance = Math.abs((x1 = x1 + v1) - (x2 = x2 + v2));

        }

        return "NO";

    }

    public static void main(String[] args){

        System.out.println("Print" + kangaroo(0,2,5,3));

    }

}
