package Lesson7;

import java.util.Random;

public class Program {
    public static void main(String[] args) {
        Random rnd = new Random();
        int vertexCount = 10;
        int edgeCount = 15;
        int rndV1 = -1;
        int rndV2 = -1;

        Graph graph = new Graph(vertexCount);
        for (int i = 0; i < edgeCount; i++) {
            rndV1 = rnd.nextInt(vertexCount);
            rndV2 = rnd.nextInt(vertexCount);
            graph.addEdge(rndV1, rndV2);
        }
        BreadthFirstPaths bfs = new BreadthFirstPaths(graph, 0);
        System.out.println(bfs.hasPathTo(vertexCount-2));
        System.out.println(bfs.pathTo(vertexCount-2));
        System.out.println(bfs.distTo(vertexCount-2));

        /*Graph graph = new Graph(6);
        graph.addEdge(0, 2);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(5, 3);
        graph.addEdge(4, 3);
        graph.addEdge(3, 2);
        graph.addEdge(4, 2);
        graph.addEdge(0, 5);
        BreadthFirstPaths bfs = new BreadthFirstPaths(graph, 0);
        System.out.println(bfs.hasPathTo(3));
        System.out.println(bfs.pathTo(3));
        System.out.println(bfs.distTo(3));*/
    }
}