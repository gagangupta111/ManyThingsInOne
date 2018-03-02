package com.HackerEarth;

public class Mars {

    public static void main(String[] args){

        String s = "SOSOOSOSOSOSOSSOSOSOSOSOSOS";
        System.out.println(marsExploration(s));

    }

    static int marsExploration(String s) {

        int count = 0;

        if (s.length() == 0){
            return 0;
        }

        for (int i = 0; i < s.length();){

            if ( s.charAt(i) != 'S' )
                count++;
            if ( s.charAt(i+1) != 'O' )
                count++;
            if ( s.charAt(i+2) != 'S' )
                count++;

            i = i + 3;

        }
        return count;
    }

}
