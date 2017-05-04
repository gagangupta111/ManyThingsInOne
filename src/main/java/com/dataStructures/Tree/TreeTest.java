package com.dataStructures.Tree;

import java.util.List;

public class TreeTest {

    public static void main(String[] args){

        System.out.printf("hello");

        Node tree = Node.createTree();
        System.out.println();
        tree.inOrder(tree);

        Node key = new Node(60);
        tree.findPredSucc(key, tree);

        System.out.println();
        BTreePrinter.printNode(tree);

        BinaryTreeToBST binaryTreeToBST = new BinaryTreeToBST();
        binaryTreeToBST.convertToBST(tree);

        System.out.println();
        BTreePrinter.printNode(tree);

        List<Integer> list = binaryTreeToBST.getList();

        System.out.println();

        for (int x: list){
            System.out.println(x);
        }

        int sum  = 106;

        int i = 0;
        int j = list.size() - 1;

        System.out.println( " sum : " + sum);

        while (i != j){

            if (sum > (list.get(0) + list.get(j))){

                System.out.println(" These 2 pointers : " + " " + list.get(i) + " " + list.get(j) + " sum : " + (list.get(i) + list.get(j)));
                i++;

            }else if (sum < (list.get(0) + list.get(j))){

                System.out.println(" These 2 pointers : " + " " + list.get(i) + " " + list.get(j) + " sum : " + (list.get(i) + list.get(j)));
                j--;

            }else break;

        }

        System.out.println(" These 2 pointers : " + " " + list.get(i) + " " + list.get(j) + " sum : " + sum);

    }
}