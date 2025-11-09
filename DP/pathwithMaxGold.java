class PathWithMaxGold {
    int max = 0;
    public int getMaximumGoldMemo(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] != 0)
                    dfs(grid, vis, i, j, 0);
        return max;
    }

    void dfs(int[][] g, boolean[][] vis, int i, int j, int gold) {
        if (i < 0 || j < 0 || i >= g.length || j >= g[0].length || g[i][j] == 0 || vis[i][j]) {
            max = Math.max(max, gold);
            return;
        }
        vis[i][j] = true;
        dfs(g, vis, i + 1, j, gold + g[i][j]);
        dfs(g, vis, i - 1, j, gold + g[i][j]);
        dfs(g, vis, i, j + 1, gold + g[i][j]);
        dfs(g, vis, i, j - 1, gold + g[i][j]);
        vis[i][j] = false;
    }

    public int getMaximumGoldTab(int[][] grid) {
        // Tabulation doesn’t apply well here due to backtracking nature
        // We'll just call the same DFS (backtracking) approach
        return getMaximumGoldMemo(grid);
    }
}
