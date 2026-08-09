class Solution {
    public int[] findOrder(int N, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indeg = new int[N];

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            indeg[u]++;

            adj.get(v).add(u);
        }


        int[] ans = new int[N];
        int count = 0;

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i<N; i++) {
			if (indeg[i] == 0) {
				q.offer(i);
			}
		}


        while (!q.isEmpty()) {
            int val = q.poll();

            // if(count == N-1) return new int[]{};
            ans[count] = val;
            count++;

            for (int neigh : adj.get(val)) {
                indeg[neigh]--;
                if (indeg[neigh] == 0) {
                    q.offer(neigh);
                }
            }
        }

        return count == N ? ans:new int[]{} ;
    }
}
