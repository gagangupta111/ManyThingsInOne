package com.HackerEarth;

import java.util.Stack;

public class CountingValleys {

    public static void main(String[] args){

        System.out.println(" Hello! ");
        System.out.println(countingValleys(8, "UDDDUDUU"));

    }

    static int countingValleys(int n, String s) {

        Stack<String> stack = new Stack<>();
        String on = "";
        final String mountain = "MOUNTAIN";
        final String valley = "VALLEY";
        final String surface = "SURFACE";
        on = surface;

        int valleys = 0;
        int mountains = 0;

        char[] array = s.toCharArray();

        for (char ch : array){

            if (stack.empty()){

                if (on.equals(mountain)){
                    mountains++;
                    on = surface;
                }else if (on.equals(valley)){
                    valleys++;
                    on = surface;
                }

                if ('U' == ch){

                    on = mountain;
                    stack.push("U");

                }else if ('D' == ch){

                    on = valley;
                    stack.push("D");

                }

            }else {

                if ('U' == ch){

                    if (stack.peek().equals("D")){
                        stack.pop();
                    }else {
                        stack.push("U");
                    }

                }else if ('D' == ch){

                    if (stack.peek().equals("U")){
                        stack.pop();
                    }else {
                        stack.push("D");
                    }

                }

            }

        }

        if (on.equals(mountain)){
            mountains++;
            on = surface;
        }else if (on.equals(valley)){
            valleys++;
            on = surface;
        }

        return valleys;

    }


}
