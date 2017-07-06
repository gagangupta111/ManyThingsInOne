package com.HackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MaximumElement {

    public static void main(String[] args) throws IOException {

        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        String line  = br.readLine();
        int N = Integer.parseInt(line);
        MyStack stack = new MyStack();

        for (int i = 0 ; i < N; i++){

            line = br.readLine();
            String[] split  = line.split("\\s+");
            int first = Integer.parseInt(split[0]);

            if (first == 1){

               stack.push(Integer.parseInt(split[1]));

            }else if (first == 2){

                stack.pop();

            }else {

                System.out.println(stack.getMax());

            }


        }

    }

}


class MyStack
{
    private Stack<IntPair> stack = new Stack<IntPair>();

    public void push(int i){

        if (stack.isEmpty()){
            IntPair intPair = new IntPair(i, i);
            stack.add(intPair);
        }else {
            IntPair intPair = stack.peek();
            IntPair newPair = new IntPair(i, i > intPair.getJ() ? i : intPair.getJ() );
            stack.add(newPair);
        }

    }

    public void pop(){
            stack.pop();
    }

    public int getMax(){

        return stack.peek().getJ();

    }

    public IntPair peek(){
        return stack.peek();
    }


};

class IntPair{

    public int i;
    public int j;

    public IntPair(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
}