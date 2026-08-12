class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());
        }

        int[] ans = new int[2];

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            boolean vis[] = new boolean[n + 1];

            if (dfs(adj, u, v, vis)) {
                return edges[i];
            }

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return ans;
    }

    boolean dfs(ArrayList<ArrayList<Integer>> adj, int curr, int val, boolean vis[]) {
        vis[curr] = true;
        if (curr == val)
            return true;

        for (int neigh : adj.get(curr)) {
            if (!vis[neigh]) {
                if (dfs(adj, neigh, val, vis)) {
                    return true;
                }
            }
        }

        return false;
    }
}
