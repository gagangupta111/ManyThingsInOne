package com.HackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TimeConversion {

    public static void main(String[] args) throws Exception{

        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        String line;
            line  = br.readLine();
            String newTime = "";
            int index = 0;

            if (line.charAt(8) == 'A') {

                if (line.startsWith("12")) {
                    newTime = "00";
                    index = 2;
                }
            } else if (line.charAt(8) == 'P') {

                if (!line.startsWith("12")) {
                    newTime = String.valueOf((Integer.parseInt(line.substring(0, 2)) + 12));
                    index = 2;
                }

            }

            while (index < 8) {
                newTime += line.charAt(index);
                index++;
            }

            System.out.println(newTime);

    }
}