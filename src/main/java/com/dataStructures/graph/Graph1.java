package com.dataStructures.graph;

import java.util.*;

public class Graph1 {

    private int V;
    private List<Integer> adj[];
    private Map<Character, Integer> map = new HashMap<Character, Integer>();
    private int highestValue = 0;
    private boolean[] visited;
    private int cycles = 0;

    public Graph1(int v) {

        V = v;
        adj = new LinkedList[V];
        visited = new boolean[V];

        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();

        clearVisited();
    }

    public void clearVisited(){

        for (int i = 0; i < visited.length; i++){
            visited[i] = false;
        }

    }

    private String getVertex(int value){

        Set<Map.Entry<Character, Integer>> set = map.entrySet();
        for (Map.Entry entry : set){

            if (Integer.parseInt(entry.getValue().toString()) == value){
                return entry.getKey().toString();
            }

        }
            return null;
    }

    public void addVertex(char ch){

        map.put(ch, highestValue);
        highestValue++;

    }

    public void addEdge(char a, char b){

        adj[map.get(a)].add(map.get(b));

    }

    public void DFS(char a){

        int value = map.get(a);
        DFS(value);

    }

    public void DFS(int a){

        visited[a] = true;
        System.out.print( getVertex(a) + " ");

        for (int u : adj[a]){
            if (!visited[u]){
                DFS(u);
            }
        }
    }

    public void BFS(char a){
        BFS(map.get(a));
    }

    public void BFS(int a){

        LinkedList<Integer> queue = new LinkedList<Integer>();

        queue.add(a);

        while (!queue.isEmpty()) {

            a = queue.poll();
            visited[a] = true;
            System.out.print( getVertex(a) + " ");

            for (int u : adj[a]) {
                if (!visited[u]) {
                    queue.add(u);
                }
            }

        }
    }

    public void noOfCycles(char ch){
        noOfCycles(map.get(ch));
        System.out.println(cycles);
    }

    public void noOfCycles(int a){

        visited[a] = true;

        for (int u : adj[a]){
            if (!visited[u]){
                noOfCycles(u);
            }else {
                cycles++;
            }

        }
    }

    public static void main(String[] args){

        Graph1 g = new Graph1(8);
        g.addVertex('a');
        g.addVertex('b');
        g.addVertex('c');
        g.addVertex('d');
        g.addVertex('e');
        g.addVertex('f');
        g.addVertex('g');
        g.addVertex('h');

        g.addEdge('a', 'b');
        g.addEdge('a', 'c');
        g.addEdge('b', 'c');
        g.addEdge('c', 'a');
        g.addEdge('c', 'd');
        g.addEdge('d', 'd');

        g.DFS('d');
        g.clearVisited();
        System.out.println();
        g.BFS('d');
        g.clearVisited();

        g.noOfCycles('d');

    }

}