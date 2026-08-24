class Solution {

    int[] parent;
    int[] rank;

    class Edge {
        int u, v, wt;

        Edge(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Edge> edges = new PriorityQueue<>((a,b)->Integer.compare(a.wt,b.wt));

        for(int i = 0; i<points.length;i++){
            for(int j = i+1; j<points.length;j++){
                int dist = Math.abs(points[i][0] - points[j][0]) +
                        Math.abs(points[i][1] - points[j][1]);

                edges.add(new Edge(i,j,dist));
            }
        }


        parent = new int[points.length];
		rank = new int[points.length];
		for (int i = 0; i<points.length; i++) {
			parent[i] = i;
		}

        int ans = 0;

        while(!edges.isEmpty()){
            Edge curr = edges.poll();

            if(find(curr.u) == find(curr.v)){
                continue;
            }else{
                ans += curr.wt;
                union(curr.u,curr.v);
            }
        }


        return ans;

    
    }

    int find(int x){
        if(x == parent[x]) return parent[x];

        return parent[x] = find(parent[x]);
    }

    void union(int x, int y){
        int px = find(x);
        int py = find(y);

        if(rank[px] > rank[py]){
            parent[py] = px;
        }else if(rank[px] < rank[py]){
              parent[px] = py;
        }else{
            parent[px] = py;
            rank[py]++;
        }
    }
}
