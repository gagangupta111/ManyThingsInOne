package com.HackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Fibo {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] splitted  = line.split("\\s+");

        BigInteger t1 = new BigInteger(splitted[0]);
        BigInteger t2 = new BigInteger(splitted[1]);
        int n = Integer.parseInt(splitted[2]);

        System.out.println(t1);
        System.out.println(t2);

        int index = 3;
        BigInteger t3;

        while (index <= n){

            t3 = t1.add(t2.multiply(t2));
            t1 = t2;
            t2 = t3;
            index++;
            System.out.println(t2);

        }

    }
}