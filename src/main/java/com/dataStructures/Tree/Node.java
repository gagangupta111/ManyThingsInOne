package com.dataStructures.Tree;

import java.util.LinkedList;

public class Node {

    int data, height;
    Node left;
    Node right;
    private static int count = 0;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
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
        this.data = value;
        this.left = left;
        this.right = right;
    }

    public Node(int value){
        this.data = value;
    }

    public Node insert(int key) {
        return insertion(this, key);
    }

    public Node insertion(Node node, int key){

        if (node == null)
            return (new Node(key));

        if (key < node.data)
            node.left = insertion(node.left, key);
        else if (key > node.data)
            node.right = insertion(node.right, key);
        else // Duplicate keys not allowed
            return node;

        return reBalance(node, key);

    }

    private Node reBalance(Node node, int key){


        /* 2. Update height of this ancestor node */
        node.height = 1 + Math.max(height(node.left),
                height(node.right));

        /* 3. Get the balance factor of this ancestor
              node to check whether this node became
              unbalanced */
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there
        // are 4 cases Left Left Case
        if (balance > 1 && key < node.left.data)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && key > node.right.data)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && key > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        /* return the (unchanged) node pointer */
        return node;
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        //  Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Get Balance factor of node N
    private int getBalance(Node N) {
        if (N == null)
            return 0;

        return height(N.left) - height(N.right);
    }

    public Node delete(int key){

        return deletion(this, key);

    }

    public Node deletion(Node root, int key){

        count++;
        if (root == null)  return root;

        /* Otherwise, recur down the tree */
        if (key < root.data)
            root.left = deletion(root.left, key);
        else if (key > root.data)
            root.right = deletion(root.right, key);

        else
        {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children: Get the inorder successor (smallest
            // in the right subtree)
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deletion(root.right, root.data);
        }

        return reBalanceDeletion(root, key);

    }

    private Node reBalanceDeletion(Node root, int key){


        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
        root.height = Math.max(height(root.left), height(root.right)) + 1;

        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
        //  this node became unbalanced)
        int balance = getBalance(root);

        // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0)
        {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0)
        {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;

}

    private int minValue(Node root)
    {
        int minv = root.data;
        while (root.left != null)
        {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    public void levelOrderTraversal(Node node){

        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(node);

        while (!queue.isEmpty()){

            Node node1 = queue.poll();
            if (node1.left != null){
                queue.add(node1.left);
            }
            if (node1.right != null) {
                queue.add(node1.right);
            }
            System.out.print(node1.data + " ");

        }

    }

    public int height(Node node){

        if (node != null){
            int l = height(node.left);
            int r = height(node.right);
            return Math.max(l + 1,r + 1 );
        }else {
            return 0;
        }

    }

    public void inOrder(Node tree){

        if(tree == null){
            return;
        }
        inOrder(tree.left);
        System.out.println(tree.data);
        inOrder(tree.right);

    }

    public void preOrder(Node tree){

        if(tree == null){
            return;
        }
        System.out.print(tree.data + " ");
        preOrder(tree.left);
        preOrder(tree.right);

    }

    public void postOrder(Node tree){

        if(tree == null){
            return;
        }

        postOrder(tree.left);
        postOrder(tree.right);
        System.out.println(tree.data);

    }

    public static Node createTree(){

        Node tree = new Node(50, null, null);

        tree = tree.insert(25);
        tree = tree.insert(75);

        tree = tree.insert(10);
        tree = tree.insert(35);
        tree = tree.insert(65);
        tree = tree.insert(80);

/*
        tree = tree.insert(1);
        tree = tree.insert(20);
        tree = tree.insert(30);
        tree = tree.insert(40);
        tree = tree.insert(60);
        tree = tree.insert(70);
        tree = tree.insert(77);
        tree = tree.insert(90);
*/

        return tree;

    }

    public void findPredSucc(Node node, Node tree){

        Node pred = null;
        Node succ = null;

        while (tree != null){

            if (tree.getData() < node.getData()){
                pred = tree;
                tree = tree.getRight();
            }else if (tree.getData() > node.getData()){
                succ = tree;
                tree = tree.getLeft();
            }else {
                pred = tree;
                succ = tree.getRight();
                tree = null;
            }
        continue;
        }

        System.out.println(" for node " + node.getData());
        System.out.printf(" pred " + (pred==null?null:pred.getData()));
        System.out.printf(" succ " + (succ==null?null:succ.getData()));

    }
}