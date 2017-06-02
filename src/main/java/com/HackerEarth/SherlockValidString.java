package com.HackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SherlockValidString {


    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line  = br.readLine();

        if (line.equals("") || line == null ){
            System.out.println("YES");
            return;
        }

        char[] chars = line.toCharArray();
        Arrays.sort(chars);
        char a  = chars[0];

        List<Integer> list = new ArrayList<Integer>();

        int count  = 0;
        int i = 0;

        while (i < chars.length){

            if (chars[i] == a){
                count++;
            }else {
                list.add(count);
                count = 0;
                a = chars[i];
                i--;
            }
                i++;
        }

        if (count > 0)
            list.add(count);

        Collections.sort(list);
        boolean flag1 = true;
        boolean flag2 = true;

        int x = list.get(0);
        for (int j = 0; j<list.size()-1; j++ ){
            if (x != list.get(j)){
                flag1 = false;
                break;
            }
        }

        x = list.get(list.size()-1);
        for (int j = list.size()-1; j>0; j-- ){
            if (x != list.get(j)){
                flag2 = false;
                break;
            }
        }

        if (flag1 || flag2){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }

    }
}