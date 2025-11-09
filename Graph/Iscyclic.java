import java.util.*;

class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfsCycle(i, adj, visited)) return true;
            }
        }
        return false;
    }

    private boolean bfsCycle(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, -1});
        visited[start] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0], parent = curr[1];

            for (int nei : adj.get(node)) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    q.add(new int[]{nei, node});
                } else if (nei != parent) return true;
            }
        }
        return false;
    }
}
