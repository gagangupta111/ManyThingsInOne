package com.HackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class EqualStacks {

    public static void main(String[] args) throws IOException {

        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        String line  = br.readLine();
        String[] split  = line.split("\\s+");
        List<H_Stack> listOfStacks = new ArrayList<H_Stack>();

        int[] array = new int[split.length];

        for (int i = 0; i < split.length; i++){
            array[i] = Integer.parseInt(split[i]);
        }

        for (int i = 0; i < array.length; i++){

            line  = br.readLine();
            split  = line.split("\\s+");
            H_Stack stack = new H_Stack();

            for (int j = split.length - 1; j >= 0; j--){

                stack.push(Integer.parseInt(split[j]));

            }

            listOfStacks.add(stack);

        }

        while (!isEqual(listOfStacks)){

            Collections.sort(listOfStacks);
            listOfStacks.get(0).pop();

        }

        System.out.println(listOfStacks.get(0).getHeight());

    }

    public static boolean isEqual(List<H_Stack> listOfStacks){

        int height  = listOfStacks.get(0).getHeight();
        for (int i = 1; i < listOfStacks.size(); i++){

            int secondHeight = listOfStacks.get(i).getHeight();
            if (height != secondHeight){
                return false;
            }

        }

        return true;

    }

}

class H_Stack implements Comparable
{
    private Stack<Ele_Height_Pair> stack = new Stack<Ele_Height_Pair>();

    public void push(int i){

        if (stack.isEmpty()){
            Ele_Height_Pair ele_height_pair = new Ele_Height_Pair(i, i);
            stack.add(ele_height_pair);
        }else {
            Ele_Height_Pair ele_height_pair = this.peek();
            Ele_Height_Pair newPair = new Ele_Height_Pair(i, i + ele_height_pair.getHeight());
            stack.add(newPair);
        }

    }

    public Ele_Height_Pair pop(){
        return stack.pop();
    }

    public int getHeight(){

        if (stack.isEmpty()){
            return 0;
        }

        Ele_Height_Pair ele_height_pair = stack.peek();
        return ele_height_pair.getHeight();

    }

    public int getElement(){

        if (stack.isEmpty()){
            return 0;
        }

        Ele_Height_Pair ele_height_pair = stack.peek();
        return ele_height_pair.getEle();

    }

    public Ele_Height_Pair peek(){
        return stack.peek();
    }


    public int compareTo(Object o) {
        return  ((H_Stack)o).getHeight() - this.getHeight();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

};

class Ele_Height_Pair{

    public int ele;
    public int height;

    public Ele_Height_Pair(int i, int j) {
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
