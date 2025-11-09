import java.util.*;

class DijkstraEasy {
    static class Pair {
        int node, dist;
        Pair(int n, int d) { node = n; dist = d; }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        addEdge(adj, 0, 1, 2);
        addEdge(adj, 0, 2, 4);
        addEdge(adj, 1, 2, 1);
        addEdge(adj, 1, 3, 7);
        addEdge(adj, 2, 4, 3);
        addEdge(adj, 3, 4, 1);

        int[] dist = dijkstra(V, adj, 0);
        System.out.println("Shortest distances from source 0:");
        System.out.println(Arrays.toString(dist));
    }

    static void addEdge(ArrayList<ArrayList<Pair>> adj, int u, int v, int w) {
        adj.get(u).add(new Pair(v, w));
        adj.get(v).add(new Pair(u, w)); // undirected graph
    }

    static int[] dijkstra(int V, ArrayList<ArrayList<Pair>> adj, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int u = cur.node;

            for (Pair nei : adj.get(u)) {
                if (dist[u] + nei.dist < dist[nei.node]) {
                    dist[nei.node] = dist[u] + nei.dist;
                    pq.add(new Pair(nei.node, dist[nei.node]));
                }
            }
        }
        return dist;
    }
}
