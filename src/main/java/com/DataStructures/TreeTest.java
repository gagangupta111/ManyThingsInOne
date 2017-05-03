package com.DataStructures;

public class TreeTest {

    public static void main(String[] args){

        System.out.printf("hello");

        Node tree = Node.createTree();
        System.out.println();
        tree.inOrder(tree);

        Node key = new Node(60);
        tree.findPredSucc(key, tree);

    }

}