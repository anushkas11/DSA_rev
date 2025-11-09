import java.util.*;

class Edge {
    int src, dest, wt;
    Edge(int src, int dest, int wt) {
        this.src = src;
        this.dest = dest;
        this.wt = wt;
    }
}

public class adjacencyList {
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) graph[i] = new ArrayList<>();

        graph[0].add(new Edge(0, 1, 5));
        graph[0].add(new Edge(0, 2, 1));
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 3, 3));
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 4));
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 4, 2));
        graph[4].add(new Edge(4, 2, 4));
        graph[4].add(new Edge(4, 3, 2));

        printGraph(graph);
    }

    static void printGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            System.out.print(i + " -> ");
            for (Edge e : graph[i]) {
                System.out.print("(" + e.dest + ", wt=" + e.wt + ") ");
            }
            System.out.println();
        }
    }
}
