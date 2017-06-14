package com.HackerEarth;

import java.util.ArrayList;
import java.util.List;

class ijPair{

    public int i;
    public int j;

    public ijPair(int i, int j) {
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


public class SearchTheWord {

    private char[][] array = {
            {'A','B','F','G'},
            {'D','E','C','E'},
            {'A','B','C','E'},
    };
    private List<ijPair> stack = new ArrayList<ijPair>();

    private List<ijPair> getInitialListOfChar(char a){

        List<ijPair> list = new ArrayList<ijPair>();

        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[0].length; j++){
                if (array[i][j] == a){
                    list.add(new ijPair(i, j));
                }
            }
        }

        return list;
    }

    private List<ijPair> getAdjacentListOfChar(ijPair ijPair){

        List<ijPair> list = new ArrayList<ijPair>();
        if (ijPair.getI()+1 < array.length){
            list.add(new ijPair(ijPair.getI()+1, ijPair.getJ()));
        }
        if (ijPair.getI()-1 >= 0){
            list.add(new ijPair(ijPair.getI()-1, ijPair.getJ()));
        }
        if (ijPair.getJ()+1 < array[0].length){
            list.add(new ijPair(ijPair.getI(), ijPair.getJ()+1));
        }
        if (ijPair.getJ()-1 >= 0){
            list.add(new ijPair(ijPair.getI(), ijPair.getJ()-1));
        }

        return list;
    }

    public static void main(String[] args){

        SearchTheWord searchTheWord = new SearchTheWord();
        char[] word = {'A','B','C','C','E','D'};
        char first = word[0];
        boolean flag = false;

        for (ijPair ijPair : searchTheWord.getInitialListOfChar(first)){

            searchTheWord.stack.clear();
            searchTheWord.stack.add(ijPair);
            if (searchTheWord.DFS(ijPair, 1, word)){
                flag = true;
                break;
            }
        }

        if (flag){
            System.out.println(" Found ");
            for (ijPair ijPair : searchTheWord.stack){
                System.out.println(ijPair.getI() + " " + ijPair.getJ());
            }
        }
    }

    private boolean DFS(ijPair ijPair,int i, char[] word){

        boolean flag = false;
        List<ijPair> list = getAdjacentListOfChar(ijPair);
        for (ijPair one : list){
            if (array[one.getI()][one.getJ()] == word[i]){
                stack.add(one);
                if (i +1 < word.length){
                    if (DFS(one, i+1,word)){
                        flag = true;
                        break;
                    }else {
                        stack.remove(one);
                    }
                }else {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

}