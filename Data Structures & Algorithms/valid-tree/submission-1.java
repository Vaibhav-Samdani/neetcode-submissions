class Solution {
    boolean[] vis;
    public boolean validTree(int N, int[][] edges) {
        if (edges.length != N - 1) {
            return false;
        }
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        vis = new boolean[N];

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
adj.get(v).add(u);
        }

        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                if (!dfs(adj, i, -1)) {
                    return false;
                }
            }
        }

        return true;
    }

    boolean dfs(ArrayList<ArrayList<Integer>> adj, int curr, int parent) {
        vis[curr] = true;

        for (int neigh : adj.get(curr)) {
            if (!vis[neigh]) {
                if (!dfs(adj, neigh, curr)) {
                    return false;
                }
            } else {
                if (neigh != parent) {
                    return false;
                }
            }
        }

        return true;
    }
}
