package com.HackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class IsSorted {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int testCases = Integer.parseInt(line);

        char[][] array;
        char[] splitted;
        int rowSize = 0;

        for (int i = 0; i < testCases; i++) {

            line = br.readLine();
            rowSize = Integer.parseInt(line);

            array = new char[rowSize][];

            int j = 0;
            while (j < rowSize) {

                line = br.readLine();
                char[] chars = line.toCharArray();
                Arrays.sort(chars);
                array[j] = chars;
                j++;

            }

            boolean flag = true;

            for (int k = 0; k < array[0].length; k++) {

                if (!isSorted(getCol(array, k))){
                    flag = false;
                    break;
                }
            }

            if (flag){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }

        }


    }

    static char[] getCol(char[][] matrix, int col) {

        char[] column = new char[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][col];
        }
        return column;

    }

    static boolean isSorted(char[] a) {

        for (int i = 1; i < a.length; i++) {

            if (a[i] >= a[i - 1]) {
                continue;
            } else {
                return false;
            }

        }
        return true;
    }

}
