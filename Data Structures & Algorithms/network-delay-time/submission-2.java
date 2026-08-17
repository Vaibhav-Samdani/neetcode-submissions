class Solution {
    class Pair {
        int node;
        int time;
        Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        int V = n + 1;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];

            adj.get(u).add(new Pair(v,w));
        }

        int[] result = new int[V];
        Arrays.fill(result, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.time, b.time));

        pq.offer(new Pair(k, 0));

        result[k] = 0;
       

        while (!pq.isEmpty()) {
            Pair node = pq.poll();
            if (result[node.node] < node.time)
                continue;

           
            for (Pair neigh : adj.get(node.node)) {
                if (result[neigh.node] > node.time + neigh.time) {
                    result[neigh.node] = node.time + neigh.time;
                    pq.offer(new Pair(neigh.node,result[neigh.node]));
                }
            }
        }
       
        int max = 0;

        for (int i = 1; i < result.length; i++) {
            if (result[i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, result[i]);
        }
        return max;
    }
}
