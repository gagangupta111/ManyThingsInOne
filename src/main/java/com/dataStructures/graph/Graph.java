package com.dataStructures.graph;

import java.util.*;

public class Graph {

    private int V;
    private LinkedList<Integer> adj[];
    private int cycles  = 0;
    private Stack<Integer> stack = new Stack<Integer>();

    Graph(int v) {

        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();

    }

    void addEdge(int v, int w) {

        adj[v].add(w);

    }

    public void findPath(int u, int z){

        boolean[] visited = new boolean[V];
        for (int i = 0; i < visited.length; i++){
            visited[i] = false;
        }
        findPath(u, z, visited);
        System.out.println(stack);

        if (stack.isEmpty()){
            System.out.println("empty");
        }

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

    // prints BFS traversal from a given source s
    public void BFS(int s) {
        // Mark all the vertices as not visited(By default
        // set as false)
        Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited.put(s, true);
        queue.add(s);

        while (queue.size() != 0) {

            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s + " ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {

                int n = i.next();
                if (visited.get(n) == null || !visited.get(n)) {
                    visited.put(n, true);
                    queue.add(n);
                }
            }
        }
    }

    public void DFSUtil(int s){

        Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
        DFS(s, visited);
        System.out.println(" Cycles : " + cycles);

    }

    public void DFS(int s, Map<Integer, Boolean> visited) {

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited.put(s, true);
        queue.add(s);

        while (queue.size() != 0) {

            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s + " ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {

                int n = i.next();
                if (visited.get(n) == null || !visited.get(n)) {
                    DFS(n, visited);
                }else {
                    cycles++;
                }
            }
        }
    }

    public void printAll() {

        for (int j = 0; j < V; j++){

            System.out.println(j);
            System.out.println(adj[j]);

            }
        }
    }