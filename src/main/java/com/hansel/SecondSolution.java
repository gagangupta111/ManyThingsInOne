package com.hansel;

import java.util.ArrayList;
import java.util.List;

class Node{

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    private int value;
    private Node left;
    private Node right;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}

public class SecondSolution {

    private static int i = -1;
    private static int j = -1;

    public static void main(String[] args){

        Node root = new Node(4, null, null);
        root.setLeft(new Node(3, null, null));
        root.setRight(new Node(2, null, null));

        root.getLeft().setLeft(new Node(1, null, null));
        root.getLeft().setRight(new Node(10, null, null));

        root.getRight().setRight(new Node(9, null, null));

        int difference = findLength(root, 1, 9);
        System.out.println(difference-1);

    }

    public static int findLength(Node root, int x, int y){

        List<Node> list = new ArrayList<>();
        list.add(root);
        return findInList(list, x, y);

    }

    public static int findInList(List<Node> list, int x, int y){

        if (list.isEmpty()){
            return -1;
        }

        List<Node> newList = new ArrayList<>();
        for (int m = 0; m < list.size(); m++){

            Node node = list.get(m);
            if (list.get(m).getValue() == x || list.get(m).getValue() == y){

                if (i == -1) {
                    i = m;
                }else if (j == -1){
                    j = m;
                }

            }

                if (i != -1 && j != -1){
                    return Math.abs(i-j);
                }

                if (node.getLeft() != null){
                    newList.add(node.getLeft());
                }
                if (node.getRight() != null){
                    newList.add(node.getRight());
                }


        }

        return findInList(newList, x, y);

    }


}
