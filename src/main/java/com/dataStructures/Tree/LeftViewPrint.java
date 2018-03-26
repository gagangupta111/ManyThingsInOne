package com.dataStructures.Tree;

public class LeftViewPrint {

    Node root;
    int  max_level = 0;

    // recursive function to print left view
    void leftViewUtil(Node node, int level)
    {

        if (node==null) return;

        // If this is the first node of its level
        if (max_level < level)
        {
            System.out.print(" " + node.data);
            max_level = level;
        }

        // Recur for left and right subtrees

        leftViewUtil(node.right, level+1);
        leftViewUtil(node.left, level+1);
    }

    // A wrapper over leftViewUtil()
    void leftView(Node root)
    {
        leftViewUtil(root, 1);
    }

    public static void main(String[] args) {

        System.out.printf(" Hello! ");

        Node root = new Node(20, null, null);
        root.left = new Node(10, null, null);
        root.right = new Node(30, null, null);

        root.left.left = new Node(5, null, null);
        root.left.right = new Node(15, null, null);

        root.right.left = new Node(25, null, null);
        root.right.right = new Node(35, null, null);

        LeftViewPrint print = new LeftViewPrint();
        print.leftView(root);

    }

    }
