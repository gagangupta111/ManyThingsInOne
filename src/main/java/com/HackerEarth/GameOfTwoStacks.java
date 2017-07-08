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
            Stack<Integer> h_stack_1 = new Stack<Integer>();
            int j = split.length - 1;
            for (  ; j >= 0; j--){
                h_stack_1.push(Integer.parseInt(split[j]));
            }

            line = br.readLine();
            split  = line.split("\\s+");
            Stack<Integer> h_stack_2 = new Stack<Integer>();
            j = split.length - 1;
            for (  ; j >= 0; j--){
                h_stack_2.push(Integer.parseInt(split[j]));
            }

            // initialize stack of height 1 here
            Stack_Of_Height stack_of_height_1 = new Stack_Of_Height();
            while (!h_stack_1.isEmpty() && stack_of_height_1.getHeight() + h_stack_1.peek() <= maxHeight){
                stack_of_height_1.push(h_stack_1.pop());
            }

            Stack_Of_Height stack_of_height_2 = new Stack_Of_Height();
            while (true){

                // keep on adding elements in stack of height 2 from stack 2.
                int stack_1_height = stack_of_height_1.getHeight();
                while (!h_stack_2.isEmpty() && stack_of_height_2.getHeight() + stack_1_height + h_stack_2.peek()<= maxHeight){
                    stack_of_height_2.push(h_stack_2.pop());
                }

                // count total no of elements.
                int totalSize = stack_of_height_1.size() + stack_of_height_2.size();
                if (totalSize > elementsRemoved){
                    elementsRemoved = totalSize;
                }

                // check if stack of height 1 it is not empty, in that case program should leave.
                if (stack_of_height_1.isEmpty()){
                    break;
                }

                stack_of_height_1.pop();

            }

            System.out.println(elementsRemoved);

        }
    }

}

class Stack_Of_Height{

    private Stack<Pair_Of_Ele_Height> stack = new Stack<Pair_Of_Ele_Height>();

    public int size(){
        return stack.size();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public void push(int i){

        if (stack.isEmpty()){
            Pair_Of_Ele_Height ele_height_pair = new Pair_Of_Ele_Height(i, i);
            stack.add(ele_height_pair);
        }else {
            Pair_Of_Ele_Height ele_height_pair = this.peek();
            Pair_Of_Ele_Height newPair = new Pair_Of_Ele_Height(i, i + ele_height_pair.getHeight());
            stack.add(newPair);
        }

    }

    public Pair_Of_Ele_Height pop(){
        return stack.pop();
    }

    public Pair_Of_Ele_Height peek(){
        return stack.peek();
    }

    public int getElement(){

        if (stack.isEmpty()){
            return 0;
        }

        Pair_Of_Ele_Height ele_height_pair = stack.peek();
        return ele_height_pair.getEle();

    }

    public int getHeight(){

        if (stack.isEmpty()){
            return 0;
        }

        Pair_Of_Ele_Height ele_height_pair = stack.peek();
        return ele_height_pair.getHeight();

    }

}

class Pair_Of_Ele_Height{

    public int ele;
    public int height;

    public Pair_Of_Ele_Height(int i, int j) {
        this.ele = i;
        this.height = j;
    }

    public int getEle() {
        return ele;
    }

    public void setEle(int ele) {
        this.ele = ele;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}

