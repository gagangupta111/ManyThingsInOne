package com.HackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class GemStones {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int testcases = Integer.parseInt(line);
        char[] chars;
        Set<Character> set1 = new HashSet<Character>();
        Set<Character> set2 = new HashSet<Character>();

        line = br.readLine();
        chars = line.toCharArray();
        for (char c: chars){
            set1.add(c);
        }

        for (int i = 1; i < testcases; i++){

            line = br.readLine();
            chars = line.toCharArray();
            for (char c: chars){
                if (set1.contains(c)){
                    set2.add(c);
                }
            }
            set1 = set2;
            set2 = new HashSet<Character>();
        }

        System.out.println(set1.size());
    }
}