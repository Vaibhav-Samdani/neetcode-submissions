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

            adj.get(u).add(new Pair(v, w));
        }

        int[] result = new int[V];
        Arrays.fill(result, Integer.MAX_VALUE);

        result[k] = 0;

        for (int i = 0; i <= V - 1; i++) {
            boolean updated = false;
            for (int[] time : times) {
                if (result[time[0]] != Integer.MAX_VALUE
                    && result[time[0]] + time[2] < result[time[1]]) {
                    updated = true;
                    result[time[1]] = result[time[0]] + time[2];
                }
            }

            if(!updated) break;
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
