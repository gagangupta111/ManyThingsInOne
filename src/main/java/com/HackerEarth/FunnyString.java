package com.HackerEarth;

public class FunnyString {

    public static void main(String[] args){

        String s  = "acxy";

        for(int i = 0; i < s.length()-1; i++){

            if(Math.abs(s.charAt(i) -  s.charAt(i+1)) != Math.abs(s.charAt(s.length()-(i+1)) -  s.charAt(s.length()-(i+2)))){
                System.out.println("NOT FUNNY");
                return;
            }

        }

        System.out.println("FUNNY");

    }
}
