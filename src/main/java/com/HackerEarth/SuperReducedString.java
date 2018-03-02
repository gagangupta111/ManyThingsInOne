package com.HackerEarth;

public class SuperReducedString {

    public static void main(String[] args){

        System.out.println(" Hello! ");
        String s = "fgaabbccd";
        int length  = s.length();

        if (length == 0){
            return;
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < length; i++){

            char c = s.charAt(i);
            if (i+1 == length){
                break;
            }

            char j = s.charAt(i+1);
            if (c == j){

                start = i;
                end = i+2;

                s = reduce(s, start, end);
                i = -1;
                length  = s.length();

            }

        }

        System.out.printf(s);

    }

    public static String reduce(String s, int start, int end){

            String s1 = s.substring(0, start);
            String s2 = s.substring(end, s.length());
            return s1 + s2;

    }

}
