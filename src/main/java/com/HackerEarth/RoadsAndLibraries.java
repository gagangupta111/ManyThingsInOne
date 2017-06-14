package com.HackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class RoadsAndLibraries {

    public static void main (String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line  = br.readLine();
        int queries = Integer.parseInt(line);

        for (int i = 0; i < queries; i++){

            line = br.readLine();
            String[] split = line.split("\\s+");
            int cities = Integer.parseInt(split[0]);
            int roads = Integer.parseInt(split[1]);
            int libCost = Integer.parseInt(split[2]);
            int roadCost = Integer.parseInt(split[3]);

            Graph graph = new Graph(cities);
            for (int j = 0; j < roads; j++){
                line = br.readLine();
                split = line.split("\\s+");
                graph.addEdge(Integer.parseInt(split[0])-1, Integer.parseInt(split[1])-1);
            }

            for (int j=0; j < graph.labelArray.length; j++){
                if (graph.labelArray[j][1] == 0){
                    graph.label += 1;
                    graph.BFS(j);
                }
            }

            for (int j=0; j < graph.labelArray.length; j++){
                System.out.println(graph.labelArray[j][0] + " " + graph.labelArray[j][1]);
            }

            System.out.println();
            System.out.println(graph);

            for (Graph gr : graph.getAllGraphs()){

                System.out.println(gr);

            }

        }
    }
}

 class Graph {

     private int V;
     public LinkedList<Integer> adj[];
     public int[][] labelArray;
     public int label = 0;
     public int farthest = Integer.MIN_VALUE;

     Graph(int v) {

         V = v;
         adj = new LinkedList[v];
         for (int i = 0; i < v; ++i)
             adj[i] = new LinkedList();

         labelArray = new int[v][2];
         for (int i = 0; i < v; ++i) {
             labelArray[i][0] = i;
             labelArray[i][1] = 0;
         }
     }

     void addEdge(int v, int w) {

         adj[v].add(w);

     }

     @Override
     public String toString() {
         return "Graph{" +
                 "V=" + V +
                 ", adj=" + Arrays.toString(adj) +
                 ", labelArray=" + Arrays.toString(labelArray) +
                 ", label=" + label +
                 ", farthest=" + farthest +
                 '}';
     }

     public void BFS(int s) {

         LinkedList<Integer> queue = new LinkedList<Integer>();
         labelArray[s][1] = label;
         queue.add(s);

         while (queue.size() != 0) {

             s = queue.poll();

             Iterator<Integer> i = adj[s].listIterator();
             while (i.hasNext()) {

                 int n = i.next();
                 if (labelArray[n][1] == 0) {
                     labelArray[n][1] = label;
                     queue.add(n);
                 }
             }

         }
     }

     public List<Graph> getAllGraphs() {

         // sort the array column 1 wise.
         List<Graph> graphs = new ArrayList<Graph>();
         int label = 1;
         int n = labelArray.length;
         for (int i = 0; i < n; i++) {
             for (int j = 1; j < (n - i); j++) {
                 if (labelArray[j - 1][1] > labelArray[j][1]) {
                     int temp1 = labelArray[j - 1][1];
                     int temp0 = labelArray[j-1][0];
                     labelArray[j - 1][0] = labelArray[j][0];
                     labelArray[j][0] = temp0;
                     labelArray[j - 1][1] = labelArray[j][1];
                     labelArray[j][1] = temp1;
                 }
             }
         }

         int firstLabel = labelArray[0][1];
         int count = 0;
         int initial = 0;
         for (int i = 0; i < labelArray.length; i++){

             if (firstLabel == labelArray[i][1]){
                count++;
             }else {
                 List<Integer> list = new ArrayList<Integer>();
                 Graph graph = new Graph(count);
                 for (int j = initial; j < i; j++){
                    list.add(labelArray[j][0]);
                 }
                 Collections.sort(list);
                 int starting  = list.get(0);

                 for (Integer key : list){
                     for (Integer value : adj[key]){
                         graph.addEdge(key - starting, value - starting);
                     }
                 }
                 graphs.add(graph);

                 firstLabel = labelArray[i][1];
                 count = 1;
                 initial = i;

             }

         }

        return graphs;
     }

 }