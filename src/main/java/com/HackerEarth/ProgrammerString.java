package com.HackerEarth;

import java.util.HashMap;
import java.util.Map;

public class ProgrammerString {

    public static void main(String[] args){

        System.out.println(find("programmerprogramerrrrrrprogrammerprogramerrrrrr" +
                "programmerprogramerrrrrrprogrammerprogramerrrrrrprogrammerprogramerrrrrrprogrammerprogramerrrrrr" +
                "programmerprogramerrrrrrprogrammerprogramerrrrrrprogrammerprogramerrrrrrprogrammerprogramerrrrrr" +
                "programmerprogramerrrrrrprogrammerprogramerrrrrrprogrammerprogramerrrrrr" +
                "programmerprogramerrrrrrprogrammerprogramerrrrrrprogrammerprogramerrrrrrprogrammerprogramerrrrrr" +
                "programmerprogramerrrrrrprogrammerprogramerrrrrrprogrammerprogramerrrrrrprogrammerprogramerrrrrr" +
                "programmerprogramerrrrrrprogrammerprogramerrrrrrprogrammerprogramerrrrrrprogrammerprogramerrrrrr" +
                "programmerprogramerrrrrrprogrammerprogramerrrrrrprogrammerprogramerrrrrrprogrammerprogramerrrrrr" +
                "programmerprogramerrrrrrprogrammerprogramerrrrrrprogrammerprogramerrrrrrprogrammerprogramerrrrrr" +
                "programmerprogramerrrrrrprogrammerprogramerrrrrrprogrammerprogramerrrrrrprogrammerprogramerrrrrr"));

    }

    public static int find(String s){

        return findint(s);

    }

    public static int findint(String s){

        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int indexF = chars.length;
        int indexR = chars.length;
        boolean foundF = false;
        boolean foundR = false;

        for (int i = 0; i < chars.length; i++){

            if (map.get(chars[i]) == null) {
                map.put(chars[i], 1);
            } else {
                map.put(chars[i], map.get(chars[i])+1);
            }

            if (isDone(map)){
                indexF = i;
                foundF = true;
                break;
            }

        }

        map.clear();

        for (int i = chars.length-1; i > indexF; i--){

            if (map.get(chars[i]) == null) {
                map.put(chars[i], 1);
            } else {
                map.put(chars[i], map.get(chars[i])+1);
            }

            if (isDone(map)){
                indexR = i;
                foundR = true;
                break;
            }

        }

        if (foundF && foundR && (indexR - indexF > 1)){
            return indexR - indexF - 1;
        }

        return 0;

    }

    public static boolean isDone(Map<Character, Integer> map){

        if (map.get('p') != null && map.get('p').intValue() >= 1){
            if (map.get('r') != null && map.get('r').intValue() >= 3){
                if (map.get('o') != null && map.get('o').intValue() >= 1){
                    if (map.get('g') != null && map.get('g').intValue() >= 1){
                        if (map.get('a') != null && map.get('a').intValue() >= 1){
                            if (map.get('m') != null && map.get('m').intValue() >= 2){
                                if (map.get('e') != null && map.get('e').intValue() >= 1){
                                    map.clear();
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

}


