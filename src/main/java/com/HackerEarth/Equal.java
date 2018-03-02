package com.HackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Equal {

    private static int index = 0;

    public static void main(String[] args) throws Exception{

        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        String line  = br.readLine();
        int testCases = Integer.parseInt(line);

        List<Integer> list = new ArrayList<Integer>();


        int[] cases = new int[testCases];
        Integer[] students;
        String[] splitted;
        int count = 0;

        for (int i = 0; i<testCases; i++){

            index = count = 0;
            line = br.readLine();
            students = new Integer[Integer.parseInt(line)];

            line = br.readLine();
            splitted = line.split("\\s+");

            int j = 0;
            while (j < splitted.length){
                students[j] = (Integer.parseInt(splitted[j]));
                j++;
            }

            Arrays.sort(students);
            while (!checkIfEqual(students)){

                int diff = difference(students);

                if (diff >= 5){
                    diff = 5;
                }else if (diff >= 2){
                    diff = 2;
                }else{
                    diff = 1;
                }

                int k = 0;
                while (k < students.length){

                    if (k!= index) {
                        students[k] = students[k] + diff;
                    }
                    k++;

                }

                count++;

            }

            System.out.println(count);

        }


    }

    static boolean checkIfEqual(Integer[] students){

        boolean isEqual = students[0].equals(students[(students.length - 1)]);
        return isEqual;

    }

    static int difference(Integer[] students){

        int diff = 0;
        if (index > 0 && students[index]>students[index-1]){
            index--;
        }

        while (index < students.length && diff == 0){
            diff = students[index+1] - students[index];
            index++;
        }
        return diff;

    }

}