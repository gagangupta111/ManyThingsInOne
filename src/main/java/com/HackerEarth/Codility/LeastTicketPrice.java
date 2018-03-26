package com.HackerEarth.Codility;

public class LeastTicketPrice {

    public static void main(String[] args){

        int[] A = new int[8];
        A[0] = 1;
        A[1] = 2;
        A[2] = 4;
        A[3] = 5;
        A[4] = 20;
        A[5] = 24;
        A[6] = 29;
        A[7] = 30;

        int r = solution(A);
        System.out.println(r);

    }

    public static int solution(int A[]) {


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
