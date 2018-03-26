package com.HackerEarth.Codility;

class Node
{

    int data;
    Node[] child;

    Node(int item)
    {
        data = item;
    }

}

class BinaryTree
{

    Node root;

    void printkdistanceNodeDown(Node node, int k)
    {

        if (node == null || k < 0)
            return;

        if (k == 0)
        {
            System.out.print(node.data);
            System.out.println("");
            return;
        }

        for (int i = 0; i < node.child.length; i++){

            printkdistanceNodeDown(node.child[i], k - 1);

        }

    }
    int printkdistanceNode(Node node, Node target, int k)
    {
        // Base Case 1: If tree is empty, return -1
        if (node == null)
            return -1;

        // If target is same as root.  Use the downward function
        // to print all nodes at distance k in subtree rooted with
        // target or root
        if (node == target)
        {
            printkdistanceNodeDown(node, k);
            return 0;
        }

        for (int i = 0; i < node.child.length; i++) {

            // Recur for left subtree
            int dl = printkdistanceNode(node.child[i], target, k);

            // Check if target node was found in left subtree
            if (dl != -1)
            {

                // If root is at distance k from target, print root
                // Note that dl is Distance of root's left child from
                // target
                if (dl + 1 == k)
                {
                    System.out.print(node.data);
                    System.out.println("");
                }

                // Else go to right subtree and print all k-dl-2 distant nodes
                // Note that the right child is 2 edges away from left child
                else
                    printkdistanceNodeDown(node.child[i],k - dl - 2);
                // Add 1 to the distance and return value for parent calls
                return 1 + dl;
            }


        }
        // If target was neither present in left nor in right subtree
        return -1;
    }

    // Driver program to testAge the above functions
    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();

        /* Let us construct the tree shown in above diagram */
        tree.root = new Node(20);
        tree.root.child = new Node[2];

        tree.root.child[0] = new Node(8);
        tree.root.child[1] = new Node(22);

        tree.root.child[0].child[0] = new Node(4);
        tree.root.child[0].child[1] = new Node(12);
        tree.root.child[0].child[1].child[0] = new Node(10);
        tree.root.child[0].child[1].child[0] = new Node(14);
        Node target = tree.root.child[0];

        tree.printkdistanceNode(tree.root, target, 2);
    }
}

// This code has been contributed by Mayank Jaiswal