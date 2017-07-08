package com.HackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SimpleTextEditor {

    private static StringBuilder actualString = new StringBuilder();
    private static Stack<Pair_Of_Int_String> stack = new Stack<Pair_Of_Int_String>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line  = br.readLine();

        int noOfOperations  = Integer.parseInt(line);

        for ( int i = 0 ; i < noOfOperations; i++){

            line = br.readLine();
            String[] split = line.split("\\s+");
            int operation = Integer.parseInt(split[0]);

            switch (operation){

                case 1:
                    actualString.append(split[1]);
                    Pair_Of_Int_String pair_of_int_string = new Pair_Of_Int_String(1, split[1]);
                    stack.push(pair_of_int_string);
                    break;

                case 2:
                    int start = actualString.length() - Integer.parseInt(split[1]);
                    int end = actualString.length();
                    String substring  = actualString.substring(start, end);
                    actualString.delete(start, end);
                    pair_of_int_string = new Pair_Of_Int_String(2, substring);
                    stack.push(pair_of_int_string);
                    break;

                case 3:
                    System.out.println(actualString.charAt(Integer.parseInt(split[1]) -1));
                    break;

                case 4:
                    pair_of_int_string = stack.pop();
                    if (pair_of_int_string.intValue == 1){

                        int lastIndex = actualString.lastIndexOf(pair_of_int_string.string);
                        actualString.delete(lastIndex, actualString.length());

                    }else if (pair_of_int_string.intValue == 2){

                        actualString.append(pair_of_int_string.string);

                    }
                    break;

            }

        }

    }

}

class Pair_Of_Int_String{

    public int intValue;
    public String string;

    public Pair_Of_Int_String(int intValue, String string) {
        this.intValue = intValue;
        this.string = string;
    }

}