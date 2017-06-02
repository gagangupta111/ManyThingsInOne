package com.HackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RichieRich {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] splitted = line.split("\\s+");
        int changeCanBeMade = Integer.parseInt(splitted[1]);

        line = br.readLine();
        char[] chars = line.toCharArray();

        int changeRequired = 0;

        for (int i = 0, j = chars.length - 1; i < j; i++, j-- ){
            if (chars[i] != chars[j]){
                changeRequired++;
            }
        }

        if (changeCanBeMade < changeRequired){
            System.out.println(-1);
            return;
        }

        for (int i = 0, j = chars.length - 1; i <= j ; i++, j-- ){
            // 11 9 4567 9 11  4 2

            if (i == j && changeCanBeMade >= 1){
                chars[i] = chars[j] = '9';
                break;
            }

            if (changeCanBeMade >= changeRequired+2) {
                // when i have capacity to make 9 even for those who are equal.
                if (chars[i] == chars[j] && chars[j] == '9') {

                }else if (chars[i] == chars[j] && chars[j] != '9'){
                    chars[i] = chars[j] = '9';
                    changeCanBeMade -= 2;
                }

                if (chars[i] != '9' && chars[j] != '9'){
                    chars[i] = chars[j] = '9';
                    changeCanBeMade -= 2;
                    changeRequired--;
                }

                if (chars[i] != '9'){
                    chars[i] = '9';
                    changeCanBeMade--;
                    changeRequired--;
                } else if (chars[j] != '9'){
                    chars[j] = '9';
                    changeCanBeMade--;
                    changeRequired--;
                }

            }else if (changeCanBeMade >= changeRequired+1) {
                // when i have the capacity to make 9 but only for those who are not equal.
                if (chars[i] != chars[j]) {

                    if (chars[i] != '9' && chars[j] != '9') {
                        chars[i] = chars[j] = '9';
                        changeCanBeMade -= 2;
                        changeRequired--;
                    }

                    if (chars[i] != '9') {
                        chars[i] = '9';
                        changeCanBeMade--;
                        changeRequired--;
                    } else if (chars[j] != '9') {
                        chars[j] = '9';
                        changeCanBeMade--;
                        changeRequired--;
                    }
                }

            }else {
                // when there is no capacity to make 9 but can only be made palindrome.
                if (chars[i] != chars[j]) {
                    if (chars[i] < chars[j]) {
                        chars[i] = chars[j];
                    } else {
                        chars[j] = chars[i];
                    }
                    changeCanBeMade--;
                    changeRequired--;
                }
            }
        }

        for (char c: chars){
            System.out.print(c);
        }

    }
}