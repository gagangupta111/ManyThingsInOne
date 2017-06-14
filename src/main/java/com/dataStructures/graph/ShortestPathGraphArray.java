package com.dataStructures.graph;

public class ShortestPathGraphArray {

    int V = 9;
    int[][] array;

    public ShortestPathGraphArray(int V){

        array = new int[][]{
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
    }

    public int minDistance(int[] distance, boolean[] sptSet){

        int min = Integer.MAX_VALUE;
        int min_index = -1;
        for (int i = 0; i < sptSet.length; i++){
            if (sptSet[i] == false && distance[i] < min){
                min = distance[i];
                min_index = i;
            }
        }
        return min_index;
    }

    public void dijkstra(int[][] graph, int src, int dest){

        int[] distance = new int[V];
        boolean[] sptSet = new boolean[V];

        for (int i = 0; i < sptSet.length; i++){
            sptSet[i] = false;
        }

        for (int i = 0; i < distance.length; i++){
            distance[i] = Integer.MAX_VALUE;
        }

        distance[src] = 0;

        for (int count = 0; count < V-1; count++){

            int u = minDistance(distance, sptSet);
            sptSet[u] = true;

            for (int v = 0; v < V; v++) {

                // Update dist[v] only if is not in sptSet, there is an
                // edge from u to v, and total weight of path from src to
                // v through u is smaller than current value of dist[v]
                if (!sptSet[v] && graph[u][v] != 0 &&
                        distance[u] != Integer.MAX_VALUE &&
                        distance[u] + graph[u][v] < distance[v]) {

                    distance[v] = distance[u] + graph[u][v];

                }
            }
                printSolution(distance);
            if (u == dest){
                return;
            }
                }
        }

    void printSolution(int dist[])
    {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i+" \t\t "+dist[i]);
    }

    public static void main(String[] args){

        ShortestPathGraphArray array = new ShortestPathGraphArray(9);
        array.dijkstra(array.array, 0, 8);

    }

}