package com.HackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MakingAnagrams {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String aLine = br.readLine();
        String bLine = br.readLine();

        List<Character> a = new ArrayList<Character>(aLine.length());
        List<Character> b = new ArrayList<Character>(bLine.length());

        List<Character> aX = new ArrayList<Character>(bLine.length());
        List<Character> bY = new ArrayList<Character>(aLine.length());

        List<Character> aFinal;
        List<Character> bFinal;

        boolean flag = false;
        int minDeleted = Integer.MAX_VALUE;
        int toBeDeleted = Integer.MAX_VALUE;

        for (char x: aLine.toCharArray()){
            a.add(x);
        }

        for (char x: bLine.toCharArray()){
            b.add(x);
        }


        // 1st testing.
        for (int i = 0; i < b.size(); i++){
            aX.add('X');
        }

        for (int i = 0; i < a.size(); i++){
            bY.add('Y');
        }

        while (aX.size() >= 0 && bY.size() >= 0){

            aFinal = new ArrayList<Character>();
            aFinal.addAll(aX);
            aFinal.addAll(a);

            bFinal = new ArrayList<Character>();
            bFinal.addAll(b);
            bFinal.addAll(bY);

            toBeDeleted = toBeDeleted(aFinal, bFinal);
            if (toBeDeleted < minDeleted){
                minDeleted = toBeDeleted;
            }

            if (aX.size() == 0 || bY.size() == 0) {
                break;
            }

            aX.remove(0);
            bY.remove(0);

        }

        // 2nd testing.
        aX.clear();
        bY.clear();
        for (int i = 0; i < b.size(); i++){
            aX.add('X');
        }

        for (int i = 0; i < a.size(); i++){
            bY.add('Y');
        }

        while (aX.size() >= 0 && bY.size() >= 0){

            aFinal = new ArrayList<Character>();
            aFinal.addAll(a);
            aFinal.addAll(aX);

            bFinal = new ArrayList<Character>();
            bFinal.addAll(bY);
            bFinal.addAll(b);

            toBeDeleted = toBeDeleted(aFinal, bFinal);
            if (toBeDeleted < minDeleted){
                minDeleted = toBeDeleted;
            }

            if (aX.size() == 0 || bY.size() == 0) {
                break;
            }

            aX.remove(0);
            bY.remove(0);

        }

        aX.clear();
        bY.clear();

        List<Character> small = null, large = null;

        if (a.size() > b.size()){
            small = b;
            large = a;
        }else if (a.size() < b.size()){
            small = a;
            large = b;
        }

        if (small == null || large == null){
            return;
        }

        List<Character> smallFinal = new ArrayList<Character>(large.size());
        int diff = large.size() - small.size();

        for (int i = 1; i < diff; i++){

            aX.clear();
            bY.clear();
            smallFinal.clear();

            int j = 0;
            while (j < i){
                aX.add('X');
                j++;
            }
            j = i;
            while (j < diff){
                bY.add('Y');
                j++;
            }

            smallFinal.addAll(aX);
            smallFinal.addAll(small);
            smallFinal.addAll(bY);

            toBeDeleted = toBeDeleted(smallFinal, large);
            if (toBeDeleted < minDeleted){
                minDeleted = toBeDeleted;
            }

        }

        System.out.println(minDeleted);

    }

    static int toBeDeleted(List<Character> a, List<Character> b){

        int toBeDeleted = a.size() + b.size();
        int matching = 0;

        for (int i = 0; i < a.size(); i++){
            if (a.get(i) == b.get(i)){
                matching++;
            }
        }

        return toBeDeleted - (2*matching);

    }
}