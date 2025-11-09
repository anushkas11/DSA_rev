import java.util.*;

class Pair {
    int node, weight;
    Pair(int n, int w) { node = n; weight = w; }
}

public class Prims {
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).add(new Pair(1, 2));
        adj.get(0).add(new Pair(3, 6));
        adj.get(1).add(new Pair(0, 2));
        adj.get(1).add(new Pair(2, 3));
        adj.get(1).add(new Pair(3, 8));
        adj.get(1).add(new Pair(4, 5));
        adj.get(2).add(new Pair(1, 3));
        adj.get(2).add(new Pair(4, 7));
        adj.get(3).add(new Pair(0, 6));
        adj.get(3).add(new Pair(1, 8));
        adj.get(4).add(new Pair(1, 5));
        adj.get(4).add(new Pair(2, 7));

        System.out.println("Prim’s MST weight: " + primsMST(V, adj));
    }

    static int primsMST(int V, ArrayList<ArrayList<Pair>> adj) {
        boolean[] vis = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.add(new Pair(0, 0));
        int total = 0;

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int u = cur.node;
            if (vis[u]) continue;
            vis[u] = true;
            total += cur.weight;

            for (Pair nei : adj.get(u)) {
                if (!vis[nei.node]) pq.add(new Pair(nei.node, nei.weight));
            }
        }
        return total;
    }
}
