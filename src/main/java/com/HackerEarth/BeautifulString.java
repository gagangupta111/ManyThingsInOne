package com.HackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BeautifulString {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        line = br.readLine();
        char[] chars = line.toCharArray();
        int count  = 0;

        for (int i = 0; i+3 <= chars.length; ){

            if (chars[i] == '0' && chars[i+1] == '1' && chars[i+2] == '0'){
                if ( i+5 <= chars.length ){
                    if (chars[i+3] == '1' && chars[i+4] == '0'){
                        chars[i+2] = '1';
                        count++;
                        i = i+4;
                    }else{
                        chars[i+1] = '0';
                        count++;
                        i = i+3;
                    }
                    continue;
                }
                chars[i+1] = '0';
                count++;
                i = i+3;
                continue;
            }
            i++;
        }

        System.out.println(count);

    }

}
