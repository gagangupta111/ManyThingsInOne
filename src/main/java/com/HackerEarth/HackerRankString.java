package com.HackerEarth;

public class HackerRankString {

    public static void main(String[] args) {

        System.out.println(" Hello ");

        String hackerrank = "hackerrank";
        int[] array = new int[hackerrank.length()];
        String string  = "hacggkerrjgghjgjanhghgjkhg";

        int now  = 0;

        for (int i = 0; i < hackerrank.length(); i++){

            char c = hackerrank.charAt(i);
            for (int j = now; j < string.length(); j++){

                if (c == string.charAt(j)){
                    now = j+1;
                    array[i] = 1;
                    break;
                }

            }

        }

        for (int i = 0; i < array.length; i++) {

            if (array[i] != 1){
                System.out.println("NO");
            }

        }

        System.out.println("YES");

        }
}