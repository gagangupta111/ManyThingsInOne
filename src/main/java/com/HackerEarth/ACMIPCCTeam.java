package com.HackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ACMIPCCTeam {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] splitted = line.split("\\s+");

        int person = Integer.parseInt(splitted[0]);
        int topics = Integer.parseInt(splitted[1]);

        int teams = 0;
        List<Integer> list = new ArrayList<Integer>();

        int[][] array = new int[person][topics];

        for (int i = 0; i < person; i++) {

            line = br.readLine();
            splitted = line.split("");

            for (int j = 0; j < topics; j++){
                array[i][j] = Integer.parseInt(splitted[j]);
            }
        }

        // input done and transformed so far.

        int[] temp = new int[topics];
        for (int i = 0; i < person; i++){
            for (int j = i+1; j < person; j++) {

                int zeros = 0;
                for (int k = 0; k < topics; k++){
                    temp[k] = array[i][k] + array[j][k];
                }

                for (int k = 0; k < topics; k++){
                    if (temp[k] == 0){
                        zeros++;
                    }
                }
                list.add(zeros);
            }
        }

        Collections.sort(list);
        int min = list.get(0);

        System.out.println( topics-min );

        for (Integer integer : list){
            if (integer == min){
                teams++;
            }else {
                break;
            }
        }
        System.out.println(teams);
    }
}