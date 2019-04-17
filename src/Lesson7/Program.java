package Lesson7;

public class Program {
    public static void main(String[] args) {
        Graph graph = new Graph(6);
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
        System.out.println(bfs.distTo(3));
    }
}