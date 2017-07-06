package com.HackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

class TreeNode {

    public TreeNode(int data) {
        this.data = data;
    }

    public int data, height, depth;
    public TreeNode left;
    public TreeNode right;

    public void inOrder(TreeNode tree){

        if(tree == null){
            return;
        }
        inOrder(tree.left);
        System.out.print(tree.data + " ");
        inOrder(tree.right);

    }
}

public class SwapNodesAlgo {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line  = bufferedReader.readLine();
        int N = Integer.parseInt(line);

        LinkedList<TreeNode> parent = new LinkedList<TreeNode>();
        HashMap<Integer, LinkedList<TreeNode>> hashMap = new HashMap<Integer, LinkedList<TreeNode>>();

        TreeNode tree = new TreeNode(1);
        parent.add(tree);
        int count = 1;
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(tree);
        hashMap.put(count, list);

        for (int i = 0; i < N; i++){
            line  = bufferedReader.readLine();
            String[] split = line.split("\\s+");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            TreeNode qNode  = parent.poll();

            if (a != -1){
                TreeNode aNode = new TreeNode(a);
                qNode.left = aNode;
                parent.add(aNode);
            }
            if (b != -1){
                TreeNode bNode = new TreeNode(b);
                qNode.right = bNode;
                parent.add(bNode);
            }
        }

        parent.add(tree);

        while (true) {
            count++;
            LinkedList<TreeNode> depthList = new LinkedList<TreeNode>();
            LinkedList<TreeNode> q2 = new LinkedList<TreeNode>();
            while (!parent.isEmpty()) {
                TreeNode node = parent.poll();
                if (node.left != null) {
                    depthList.add(node.left);
                    q2.add(node.left);
                }
                if (node.right != null) {
                    depthList.add(node.right);
                    q2.add(node.right);
                }
            }
            hashMap.put(count, depthList);
            parent = q2;
            if (parent.isEmpty()){
                break;
            }
        }

        line  = bufferedReader.readLine();
        int T = Integer.parseInt(line);
        for (int i = 0; i < T; i++){

            line  = bufferedReader.readLine();
            int K = Integer.parseInt(line);

            while (K <= count){
                for (TreeNode node : hashMap.get(K)){
                    TreeNode temp = node.left;
                    node.left = node.right;
                    node.right = temp;
                }
                K = 2*K;
            }
            tree.inOrder(tree);
            System.out.println();
        }

    }

}
