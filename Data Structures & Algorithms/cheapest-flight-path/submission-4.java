class Solution {
    class Pair {
        int node;
        int dist;
        int stop;

        Pair(int node, int dist, int stop) {
            this.node = node;
            this.dist = dist;
            this.stop = stop;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] result = new int[n];

        Arrays.fill(result, Integer.MAX_VALUE);
        result[src] = 0;
       
        

        for (int i = 0; i <= k; i++) {
            int[] cost = Arrays.copyOf(result,n);
            for (int[] flight : flights) {
                int u = flight[0];
                int v = flight[1];
                int w = flight[2];
                if (result[u] != Integer.MAX_VALUE && cost[v] > result[u] + w) {
                    cost[v] = result[u] + w;
                }
            }

            result = cost;
        }
        

        return result[dst] == Integer.MAX_VALUE ? -1 : result[dst];
    }
}
