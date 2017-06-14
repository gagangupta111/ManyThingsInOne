package com.dataStructures.graph;

public class GraphTest {

    public static void main(String args[])
    {
        Graph g = new Graph(9);

        g.addEdge(0, 1);
        g.addEdge(1, 0);

        g.addEdge(0, 2);
        g.addEdge(2, 6);
        g.addEdge(6, 7);
        g.addEdge(7, 2);
        g.addEdge(7, 8);

        g.addEdge(0, 3);
        g.addEdge(3, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 2);
        g.addEdge(5, 4);

        g.printAll();

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");
        // g.BFS(2);

        System.out.println();
        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");
        // g.DFSUtil(2);

        System.out.println(" Find path ");
        g.findPath(0,5);

    }
}