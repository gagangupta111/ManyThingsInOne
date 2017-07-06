package com.HackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GameOfTwoStacks {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int noOfGames = Integer.parseInt(line);

        for (int  i = 0; i < noOfGames; i++){

            line = br.readLine();
            String[] split  = line.split("\\s+");

            int maxHeight = Integer.parseInt(split[2]);
            int totalSum = 0;
            int elementsRemoved = 0;

            line = br.readLine();
            split  = line.split("\\s+");
            H_Stack h_stack_1 = new H_Stack();
            int j = split.length - 1;
            for (  ; j >= 0; j--){
                h_stack_1.push(Integer.parseInt(split[j]));
            }

            line = br.readLine();
            split  = line.split("\\s+");
            H_Stack h_stack_2 = new H_Stack();
            j = split.length - 1;
            for (  ; j >= 0; j--){
                h_stack_2.push(Integer.parseInt(split[j]));
            }

            while (!h_stack_1.isEmpty() && !h_stack_2.isEmpty() && totalSum < maxHeight){

                if (h_stack_1.getElement() < h_stack_2.getElement()){
                    totalSum += h_stack_2.getElement();
                    h_stack_2.pop();
                    elementsRemoved++;
                }else {
                    totalSum += h_stack_2.getElement();
                    h_stack_2.pop();
                    elementsRemoved++;
                }

            }

            H_Stack non_empty_stack = new H_Stack();
            if (h_stack_1.isEmpty()) {
                non_empty_stack = h_stack_2;
            }else if (h_stack_2.isEmpty()){
                non_empty_stack = h_stack_1;
            }

            while (!non_empty_stack.isEmpty() && totalSum < maxHeight){
                totalSum += non_empty_stack.getElement();
                non_empty_stack.pop();
                elementsRemoved++;
            }


            System.out.println(elementsRemoved);

        }
    }

}

