package com.HackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CaesarCipher {

    public static void main(String[] args){

        System.out.println(" Hello ");
        BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));

        String line = "";
        try {

            line = bf.readLine();
            line = bf.readLine();

        }catch (Exception e){}

        String s = line;
        try {
            line = bf.readLine();
        }catch (Exception e){}

        int move = Integer.parseInt(line);
        move = move%26;
        String[] splitted = s.split("");

        char[] ascii1 = s.toCharArray();

        for(int i = 0; i < ascii1.length; i++){

            int x = (int)ascii1[i];
            if ((x >= 65 && x <= 90)){
                if (((x + move) >= 65 && (x + move) <= 90))
                x = x + move;
                else {
                    x = 65 + (x + move - 90) - 1;
                }
            }

            if (x >= 97 && x <= 122){
                if (((x + move) >= 97 && (x + move) <= 122))
                    x = x + move;
                else {
                    x = 97 + (x + move - 122) - 1;
                }
            }

            ascii1[i] = (char)x;

        }

        s = String.valueOf(ascii1);
        System.out.println(s);
    }

}
