package com.dataStructures.graph;

import java.util.HashMap;
import java.util.Map;

public class GraphTest {

    public static void main(String args[])
    {

        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.printAll();

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");
        g.BFS(2);

        System.out.println();
        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");
        g.DFSUtil(2);

    }

}
