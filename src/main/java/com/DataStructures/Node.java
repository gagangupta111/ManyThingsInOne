package com.DataStructures;

public class Node {

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

    public Node(){}

    public Node(int value, Node left, Node right){
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Node(int value){
        this.value = value;
    }

    public void inOrder(Node tree){

        if(tree == null){
            return;
        }
        inOrder(tree.left);
        System.out.println(tree.value);
        inOrder(tree.right);

    }

    public void preOrder(Node tree){

        if(tree == null){
            return;
        }
        System.out.println(tree.value);
        inOrder(tree.left);
        inOrder(tree.right);

    }

    public void postOrder(Node tree){

        if(tree == null){
            return;
        }

        inOrder(tree.left);
        inOrder(tree.right);
        System.out.println(tree.value);

    }

    public static Node createTree(){

        Node tree = new Node(50, null, null);
        Node node = new Node(25, null, null);
        tree.setLeft(node);
        node = new Node(12, null, null);
        tree.getLeft().setLeft(node);
        node = new Node(35, null, null);
        tree.getLeft().setRight(node);

        node = new Node(75, null, null);
        tree.setRight(node);

        node = new Node(60, null, null);
        tree.getRight().setLeft(node);

        node = new Node(80, null, null);
        tree.getRight().setRight(node);

        return tree;

    }

    public void findPredSucc(Node node, Node tree){

        Node pred = null;
        Node succ = null;

        while (tree != null){

            if (tree.getValue() < node.getValue()){
                pred = tree;
                tree = tree.getRight();
            }else if (tree.getValue() > node.getValue()){
                succ = tree;
                tree = tree.getLeft();
            }else {
                pred = tree;
                succ = tree.getRight();
                tree = null;
            }
        continue;
        }

        System.out.println(" for node " + node.getValue());
        System.out.printf(" pred " + (pred==null?null:pred.getValue()));
        System.out.printf(" succ " + (succ==null?null:succ.getValue()));

    }
}