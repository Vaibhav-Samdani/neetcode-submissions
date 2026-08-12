class Solution {
    int[] parent;
    int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int V = n+1;
        parent = new int[V];
        rank = new int[V];

        for(int i = 0; i<V;i++){
            parent[i] = i;
        }

        for(int i = 0; i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];

            if(find(u) == find(v)) return edges[i];

            union(u,v);
        }

        return new int[0];
    }

    int find(int x) {
        if (parent[x] == x)
            return x;

        return parent[x] = find(parent[x]);
    }

    void union(int x, int y){
        int px = find(x);
        int py = find(y);

        if(rank[px] < rank[py]){
            parent[px] = py;
        }else if(rank[px] > rank[py]){
            parent[py] = px;
        }else{
            parent[px] = py;
            rank[py]++;
        }
    }
}
