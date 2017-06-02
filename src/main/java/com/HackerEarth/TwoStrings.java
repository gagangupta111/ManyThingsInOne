package com.HackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class TwoStrings {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int testCases = Integer.parseInt(line);
        char[] a;
        char[] b;
        Set<Character> p;
        boolean flag = false;

        for (int i = 0; i < testCases; i++) {

            flag = false;
            a = br.readLine().toCharArray();
            b = br.readLine().toCharArray();
            p = new HashSet<Character>();

            for (char x: a){
                p.add(x);
            }

            for (char x: b){
                if (p.contains(x)){
                    flag = true;
                    break;
                }
            }

            if (flag){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }

        }




    }
}