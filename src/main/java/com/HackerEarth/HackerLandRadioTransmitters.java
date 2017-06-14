package com.HackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HackerLandRadioTransmitters {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] splitted = line.split("\\s+");
        int noOfHouses = Integer.parseInt(splitted[0]);
        int transmitterRange = Integer.parseInt(splitted[1]);

        line = br.readLine();
        splitted = line.split("\\s+");
        int[] houseNumbers = new int[noOfHouses];

        for (int i = 0; i < splitted.length; i++){
            houseNumbers[i] = Integer.parseInt(splitted[i]);
        }

        Arrays.sort(houseNumbers);
        int lastTransmitter = Integer.MIN_VALUE;
        int totalTransmitters = 0;
        List<Integer> uncoveredList = new ArrayList<Integer>();

        for (int i = 0; i < houseNumbers.length; i++){

            int house = houseNumbers[i];
            // continue if it is getting covered.
            if (Math.abs(lastTransmitter-house) <= transmitterRange){
                continue;
            }
            // check if it is covering all in uncovered list. if yes then add it to uncovered list.
            // if not covering all in uncovered list then go back and add a transmieer there and empty uncovered list.
            boolean flag = false;
            for (Integer uncovered: uncoveredList){
                if (house - uncovered > transmitterRange){
                    flag = true;
                    break;
                }
            }

            if (uncoveredList.isEmpty() || !flag){
                uncoveredList.add(house);
                continue;
            }

            // put transmitter on previous house visited
            lastTransmitter = houseNumbers[--i];
            totalTransmitters++;
            uncoveredList.clear();

        }

        if (!uncoveredList.isEmpty() && uncoveredList.size() > 0){
            totalTransmitters++;
        }

        System.out.println(totalTransmitters);

    }
}