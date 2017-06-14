package com.HackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KaprekarModified {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        String[] splitted;

        long init = Long.parseLong(br.readLine());
        long end = Long.parseLong(br.readLine());

        StringBuilder sum1 = new StringBuilder();
        StringBuilder sum2 = new StringBuilder();
        boolean flag  = false;

        for (long i = init; i <= end; i++){

            sum1 = new StringBuilder();
            sum2 = new StringBuilder();

            line = String.valueOf(i);
            splitted = line.split("");

            line = String.valueOf(i*i);
            splitted = line.split("");
            int index = (splitted.length/2 - 1) < 0 ? 0 : (splitted.length/2 - 1) ;

            while (index < splitted.length){

                sum1 = new StringBuilder();
                sum2 = new StringBuilder();

                for (int j = 0; j <= index; j ++){
                    sum1.append(splitted[j]);
                }

                for (int j = index+1; j < splitted.length; j ++){
                    sum2.append(splitted[j]);
                }

                if (!"".equals(sum2.toString()) && Long.parseLong(sum2.toString()) == 0){
                    sum2 = new StringBuilder("-1");
                }

                if ("".equals(sum2.toString())){
                    sum2 = new StringBuilder("0");
                }

                if (Long.parseLong(sum1.toString()) + Long.parseLong(sum2.toString()) == i){
                    System.out.print(i + " ");
                    flag = true;
                    break;
                }
                    index++;
            }
        }

        if (!flag){
            System.out.println("INVALID RANGE");
        }

    }
}