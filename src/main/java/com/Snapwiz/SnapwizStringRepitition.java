package com.Snapwiz;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SnapwizStringRepitition {

    public static void main(String[] args){

        String[] array = new String[4];
        array[0] = "27153716537";
        array[1] = "38262682376";
        array[2] = "826648236";
        array[3] = "863547624";

        for (String string : returnBack(array, 4)){

            System.out.println(string);

        }

    }

    public static String[] returnBack(String[] inputStrings, int n){

        StringBuilder stringBuilder = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        String[] result = new String[n];
        int count = 0;
        for (String string : inputStrings){

            stringBuilder = new StringBuilder();
            map = new HashMap<>();
            char[] array = string.toCharArray();
            for (char ch: array){

                if (map.get(new Character(ch)) == null){
                    map.put(new Character(ch), new Integer(1));
                    stringBuilder.append(ch);
                }

            }

            result[count++] = stringBuilder.toString();

        }

        return result;

    }

}
