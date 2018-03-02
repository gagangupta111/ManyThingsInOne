package com;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lexicographic_Permutation
{

    public static int[] lexicographicOrder(int N)
    {

        int[] binary = new int[(int) Math.pow(2, N)];

        for (int i = 0; i < Math.pow(2, N); i++)
        {

            int b = 1;
            binary[i] = 0;
            int num = i;

            while (num > 0)
            {
                binary[i] += (num % 2) * b;
                num /= 2;
                b = b * 10;
            }
        }
        return binary;
    }

    public static void main(String args[])
    {

        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        String string = "";
        try{
            string  = br.readLine();
        }catch (Exception e){}

        char[] ch   =   string.toCharArray();

        int N = ch.length;

        int[] sequence = new int[N];
        for (int i = 0; i < N; i++)
            sequence[i] = Character.getNumericValue(ch[i]);

        for (int i = 1; i < N; i++)
        {
            int j = i;
            int temp = sequence[i];
            while (j > 0 && temp < sequence[j - 1])
            {
                sequence[j] = sequence[j - 1];
                j = j - 1;
            }
            sequence[j] = temp;
        }

        int[] mask = new int[(int) Math.pow(2, N)];
        mask = lexicographicOrder(N);
        for (int i = 0; i < Math.pow(2, N); i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (mask[i] % 10 == 1)

                    System.out.print("" + (char)( sequence[j] + 87 )  );
                    mask[i] /= 10;
            }
            System.out.println();
        }
    }
}