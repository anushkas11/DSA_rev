import java.util.*;

class BellmanFordEasy {
    static class Edge {
        int src, dest, wt;
        Edge(int s, int d, int w) { src = s; dest = d; wt = w; }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 6));
        edges.add(new Edge(0, 2, 7));
        edges.add(new Edge(1, 2, 8));
        edges.add(new Edge(1, 3, 5));
        edges.add(new Edge(1, 4, -4));
        edges.add(new Edge(2, 3, -3));
        edges.add(new Edge(2, 4, 9));
        edges.add(new Edge(3, 1, -2));
        edges.add(new Edge(4, 0, 2));
        edges.add(new Edge(4, 3, 7));

        bellmanFord(V, edges, 0);
    }

    static void bellmanFord(int V, ArrayList<Edge> edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Relax edges V-1 times
        for (int i = 0; i < V - 1; i++) {
            for (Edge e : edges) {
                if (dist[e.src] != Integer.MAX_VALUE && dist[e.src] + e.wt < dist[e.dest])
                    dist[e.dest] = dist[e.src] + e.wt;
            }
        }

        // Check for negative cycle
        for (Edge e : edges) {
            if (dist[e.src] != Integer.MAX_VALUE && dist[e.src] + e.wt < dist[e.dest]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

        System.out.println("Shortest distances from source " + src + ":");
        System.out.println(Arrays.toString(dist));
    }
}
