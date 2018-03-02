package com.HackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LuckBalance {

    public static void main(String[] args) throws IOException {

        System.out.println(" Hello ! ");
        int maxLuck = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line  = "";

        line = br.readLine();
        String[] split = line.split("\\s+");
        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);

        List<TwoIntegers> list = new ArrayList<TwoIntegers>();

        for (int i = 0; i< N; i++){

            line = br.readLine();
            split = line.split("\\s+");
            int A = Integer.parseInt(split[0]);
            int B = Integer.parseInt(split[1]);

            if (B == 0){

                if (A > 0){
                    maxLuck += A;
                }

            }else {
                TwoIntegers twoIntegers = new TwoIntegers(A, B);
                list.add(twoIntegers);
            }

        }

        if (list.size() > K) {

            Collections.sort(list, new bComparator());
            int i = 0;
            for (; i < K; i++){

                    if (list.get(i).getA() > 0) {
                        maxLuck += list.get(i).getA();
                    }

            }

            for (; i < list.size(); i++){

                maxLuck -= list.get(i).getA();

            }


        }

        System.out.println();
        System.out.println(maxLuck);

    }

}

class TwoIntegers{

    private int a;
    private int b;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public TwoIntegers(int a, int b) {

        this.a = a;
        this.b = b;

    }

    @Override
    public String toString() {

        return "TwoIntegers{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

}

class bComparator implements Comparator<TwoIntegers>{

    @Override
    public int compare(TwoIntegers o1, TwoIntegers o2) {
        return o2.getA() - o1.getA();
    }
}
