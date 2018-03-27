package com.HackerRank;

//Price of bitcoin during a week: [10, 18, 260, 31, 4, 53, 69]
//Day number starts with Day 0 and goes till Day 6. So the price on Day 0 is $10 and on the 6th day it is $69. Find the buying, selling days and the maximum profit that you can earn during this week by buying and selling the bitcoins.

// [1, 2, 1, 2, 1, 2, 1]

// 4, 10, 18, 31, 53, 69. 260
// 3 > 1
// 4 < 6
// 3 < 5

public class Test {

    public static void main(String[] args) throws Exception {

        // int[] array =  {20, 0, 250, 200, 300, 0, 300};
        int[] array =  {10, 18, 260, 31, 4, 53, 69};

        int profit = 0;
        int buyingPrice  = Integer.MAX_VALUE;
        int sellingPrice = Integer.MIN_VALUE;
        int currentPrice = Integer.MAX_VALUE;

        for(int i = 0; i <= 6; i++){

            currentPrice = array[i];
            // 3 valid cases.
            // 1st case : currentPrice is more than buyingPrice price and

            if ( ( currentPrice > buyingPrice && currentPrice < sellingPrice ) || ( currentPrice < buyingPrice)) {

                // deal and reset here.
                int diff = deal(buyingPrice, sellingPrice);
                profit = profit + diff;
                buyingPrice = currentPrice;
                sellingPrice = currentPrice;

            }else if (currentPrice > buyingPrice && currentPrice > sellingPrice ){

                // do not change buying price but change selling price here.
                sellingPrice = currentPrice;

            }

        }

            // deal and reset here.
            int diff = deal(buyingPrice, sellingPrice);
            profit = profit + diff;

        System.out.println(profit);

    }

    private static int deal(int buying, int selling){

        if(selling > buying){
            return selling - buying;
        }

        else return 0;

    }

}
