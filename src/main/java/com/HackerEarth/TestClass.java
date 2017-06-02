package com.HackerEarth;


/* IMPORTANT: Multiple classes and nested static classes are supported */

import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility  classes
import java.util.*;


class TestClass {

    private static int N, K, Q;
    private static Node root;
    private static int[][] queries;

    public static void main(String args[] ) throws Exception {

        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int k = s.nextInt();
*/

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] splited = line.split("\\s+");

        N = Integer.parseInt(splited[0]);
        K = Integer.parseInt(splited[1]);

        root  = new Node();
        Node node  = root;

        for (int i = 0; i < K; i++) {

            line = br.readLine();
            splited = line.split("\\s+");

            node.cityCount = Integer.parseInt(splited[0]);
            node.cities = new int[node.cityCount];

            for (int j = 1; j <= node.cityCount; j++) {
                node.cities[j-1] = Integer.parseInt(splited[j]);
            }

            node.next = new Node();
            node = node.next;

        }

        line = br.readLine();
        splited = line.split("\\s+");

        Q = Integer.parseInt(splited[0]);
        queries = new int[Q][2];

        for (int i = 0; i < Q; i++) {

            line = br.readLine();
            splited = line.split("\\s+");

            queries[i][0] = Integer.parseInt(splited[0]);
            queries[i][1] = Integer.parseInt(splited[1]);

        }

        for (int i = 0; i < Q; i++) {

            Node x = findNode(queries[i][0]);
            //System.out.print(" x :" + x.cityCount);

            Node y = findNode(queries[i][1]);
            //System.out.print(" y :" + y.cityCount);

            printDistance(x, y);

        }

    }

    public static Node findNode(int x){

        Node node = root;
        while(node != null){

            for(int i = 0; i < node.cityCount; i++){

                if(node.cities[i] == x){
                    return node;
                }

            }
            node  = node.next;
        }

        return null;

    }

    public static void printDistance(Node x, Node y){

        boolean flag = false;
        int count = 0;

        Node node = root;
        while(node != null){

            if(node == x && node == y){
                break;
            }
            if(node == x || node == y){
                flag = !flag;
            }
            if(flag){
                count++;
            }

            node  = node.next;

        }

        System.out.println(count);

    }

}

class Node{

    public int cityCount;
    public Node next, prev;
    public int[] cities;

}
