package com.HackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class StringConstruction {

    public static void main(String[] args) throws Exception{

        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        String line  = br.readLine();
        int testCases = Integer.parseInt(line);
        char[] s;
        Set<Character> p;
        int cost = 0;

        for (int i = 0; i<testCases; i++) {

            cost = 0;
            line = br.readLine();
            s = line.toCharArray();
            p = new HashSet<Character>();

            for (Character c : s){

                if (!p.contains(c)){
                    p.add(c);
                    cost++;
                }
            }
            System.out.println(cost);
        }
    }
}
