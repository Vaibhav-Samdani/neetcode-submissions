class Solution {
    public int countComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[n];

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                count++;
                dfs(adj, vis, i);
            }
        }

        return count;
    }

    void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int curr) {
        vis[curr] = true;

        for (int neigh : adj.get(curr)) {
            if (!vis[neigh]) {
                dfs(adj, vis, neigh);
            }
        }
    }
}
