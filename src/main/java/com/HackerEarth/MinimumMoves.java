package com.HackerEarth;

public class MinimumMoves {

    public static void main(String[] args){

        System.out.println(reachTarget(10));

    }


    static int reachTarget(int target)
    {

        target = Math.abs(target);
        int sum = 0, step = 0;

        while (sum < target || (sum - target) % 2 != 0) {

            step++;
            sum += step;

        }

        return step;
    }

}
