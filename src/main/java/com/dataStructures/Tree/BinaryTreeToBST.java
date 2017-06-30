package com.dataStructures.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeToBST {

    private List<Integer> list = new ArrayList<Integer>();
    private int i = 0;
    private Node newRoot = null;

    public List<Integer> getList() {
        return list;
    }

    public Node convertToBST(Node tree){

        convertToArray(tree);
        Collections.sort(list);
        inOrderReplace(tree);
        return tree;

    }

    public void inOrderReplace(Node tree){

        if(tree == null){
            return;
        }
        inOrderReplace(tree.getLeft());
        tree.setData(list.get(i++));
        inOrderReplace(tree.getRight());

    }

    public void convertToArray(Node tree){

        if(tree == null){
            return;
        }

        convertToArray(tree.getLeft());
        list.add(tree.getData());
        convertToArray(tree.getRight());

    }
}