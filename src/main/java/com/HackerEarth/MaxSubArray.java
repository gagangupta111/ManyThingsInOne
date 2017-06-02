package com.HackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MaxSubArray {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int testCases = Integer.parseInt(line);

        int[] array;
        String[] splitted;
        int size = 0;
        int contMax = 0;
        int nonContSum = 0;

        for (int i = 0; i < testCases; i++) {

            contMax = 0;
            nonContSum = 0;

            line = br.readLine();
            size = Integer.parseInt(line);
            array = new int[size];

            line = br.readLine();
            splitted = line.split("\\s+");

            int j = 0;

            while (j < splitted.length) {
                array[j] = (Integer.parseInt(splitted[j]));
                j++;
            }

            contMax = maxSubArraySum(array, size);
            contMax = contMax == 0?max(array, size):contMax;

            for (int k = 0; k< size; k++){

                if (array[k] >0){
                    nonContSum += array[k];
                }
            }

            nonContSum = nonContSum == 0?max(array, size):nonContSum;
            System.out.println(contMax + " " + nonContSum);

        }
    }

    static int maxSubArraySum(int a[], int size)
    {
        int max_so_far = 0, max_ending_here = 0;
        for (int i = 0; i < size; i++)
        {
            max_ending_here = max_ending_here + a[i];
            if (max_ending_here < 0)
                max_ending_here = 0;

       /* Do not compare for all elements. Compare only
          when  max_ending_here > 0 */
            else if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
        }
        return max_so_far;
    }

    static int max(int a[], int size){

        if (size == 0){
            return 0;
        }

        int max = a[0];
        for (int i = 1; i < size; i++)
        {
            if (a[i] > max){
                max = a[i];
            }
        }
        return max;
    }
}