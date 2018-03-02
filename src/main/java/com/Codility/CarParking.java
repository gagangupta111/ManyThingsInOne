package com.Codility;

public class CarParking {

    public static void main(String[] args){

        Solution solution = new Solution();
        int c  = solution.solution11("9:42", "10:43");

        int[] A = new int[8];
        A[0] = 1;
        A[1] = 2;
        A[2] = 4;
        A[3] = 5;
        A[4] = 20;
        A[5] = 24;
        A[6] = 29;
        A[7] = 30;

        int r = solution.solution(A);
        System.out.println(r);

    }

}

class Solution {

    public int solution11(String E, String L) {

        String[] first = E.split(":");
        String[] second = L.split(":");

        int startHour = Integer.parseInt(first[0]);
        int startMin = Integer.parseInt(first[1]);

        int endHour = Integer.parseInt(second[0]);
        int endMin = Integer.parseInt(second[1]);

        int differenceHour  = endHour - startHour;
        int differenceMin  = endMin - startMin;

        int total = (differenceHour*60) + differenceMin;

        int cost = 2;

        if (total == 0) {
            return cost;
        }else if (total <= 60){
            cost = cost + 3;
            return cost;
        }else if (total > 60){

            cost = cost + 3;
            total = total - 60;
            int hours = total/60;

            int remainder = total%60;
            if (remainder != 0){
                hours = hours + 1;
            }

            cost = cost + (hours*4);

        }

        return cost;

    }

    public int solution(int A[]) {


        int one = 2, seven = 7, thirty = 25;
        int length = A.length;
        int cost[] = new int[length];
        cost[0] = one;

        for (int i = 1; i < length; i++) {

            cost[i] = cost[i - 1] + one;
            int diff = A[i] - A[0];

            if (i >= 12) {

                int costThirty = thirty * ((diff + 1) / 30);
                int costThirty1 =  one * ((diff + 1) % 30);
                int costThirty7 = ((diff + 1) % 30) / 7 * seven;
                int cost30_7_1 = ((diff + 1) % 30) % 7 * one;
                int cost30_remain_7_1 = costThirty7 + (cost30_7_1 < seven ? cost30_7_1 : seven);
                int choose = (cost30_remain_7_1 < costThirty1 ? cost30_remain_7_1 : costThirty1);
                int finalCost = costThirty + (choose < thirty ? choose : thirty);
                cost[i] = cost[i] > finalCost ? finalCost : cost[i];

            } else if (i >= 3) {

                int cost7 = ((diff + 1) / 7) * seven;
                int cost7_remining = (((diff + 1) % 7) * one) < seven ? (((diff + 1) % 7) * one) : seven;
                cost7 += cost7_remining;
                cost[i] = cost[i] > cost7 ? cost7 : cost[i];

            }
        }

        return cost[length - 1];

    }
}