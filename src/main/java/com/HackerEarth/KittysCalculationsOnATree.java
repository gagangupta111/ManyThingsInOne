package com.HackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class KittysCalculationsOnATree {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] split = line.split("\\s+");

        int n = Integer.parseInt(split[0]);
        int q = Integer.parseInt(split[1]);

        GraphClass graph = new GraphClass(n);

        for (int i = 0; i < n-1; i++){

            line = br.readLine();
            split = line.split("\\s+");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            graph.addEdge(a-1, b-1);
            graph.addEdge(b-1, a-1);

        }

        for (int i = 0; i < q; i++){

            line = br.readLine();
            int size = Integer.parseInt(line);
            line  = br.readLine();
            if (size == 1){
                System.out.println(0);
                continue;
            }
            split = line.split("\\s+");
            int[] array = new int[split.length];

            for (int j = 0; j < split.length; j++){
                array[j] =  Integer.parseInt(split[j]);
            }

            long sum = 0;
            for (int k = 0; k < array.length; k++){
                for (int l = k+1; l < array.length; l++){
                    sum += array[k]*array[l]*graph.noOfEdges(array[k]-1, array[l]-1);
                }
            }

            System.out.println(sum%1000000007);

        }

    }
}




class GraphClass {

    private int V;
    private LinkedList<Integer> adj[];
    private int cycles  = 0;
    private Stack<Integer> stack = new Stack<Integer>();

    public GraphClass(int v) {

        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();

    }

    public void addEdge(int v, int w) {

        adj[v].add(w);

    }

    public int noOfEdges(int u, int z){

        stack = new Stack<Integer>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < visited.length; i++){
            visited[i] = false;
        }
        findPath(u, z, visited);

        return stack.size()==0 ? 0 : stack.size() - 1;

    }

    public boolean findPath(int u, int z, boolean[] visited) {

        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[u] = true;
        queue.add(u);
        stack.push(u);

        if (u == z){
            return true;
        }

        while (queue.size() != 0) {

            u = queue.poll();
            Iterator<Integer> i = adj[u].listIterator();
            while (i.hasNext()) {

                int n = i.next();
                if (!visited[n]) {
                    if (findPath(n, z, visited))
                        return true;
                }
            }
            stack.pop();
        }
        return false;
    }

}