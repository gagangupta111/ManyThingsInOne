package com.HackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Palindrome {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line  = br.readLine();

        char[] chars = line.toCharArray();
        Arrays.sort(chars);
        char a  = chars[0];

        int odd = 0, count  = 1;

        for(int i = 1; i < chars.length; i++){
            if (chars[i] == a){
                count++;
            }else {
                if (count%2 != 0){
                    odd++;
                }
                count = 1;
                a  = chars[i];
            }
        }

        if (odd != 0 && odd != 1){
            System.out.println("NO");
        }else {
            System.out.println("YES");
        }

    }
}