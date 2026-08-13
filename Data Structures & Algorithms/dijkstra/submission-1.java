class Solution {
    class Pair {
        int node;
        int distance;

        Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.size(); i++) {
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);
            int w = edges.get(i).get(2);

            adj.get(u).add(new Pair(v, w));
        }

        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            mp.put(i, Integer.MAX_VALUE);
        }

        mp.put(src, 0);

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(a.distance, b.distance));

        pq.offer(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair node = pq.poll();

            int v = node.node;
            int w = node.distance;
            if (w > mp.get(v)) {
                continue;
            }

            for (Pair neigh : adj.get(v)) {
                // neigh.node & neigh.distance
                if (mp.get(neigh.node) > w + neigh.distance) {
                    mp.put(neigh.node, w + neigh.distance);
                    pq.offer(new Pair(neigh.node, w + neigh.distance));
                }
            }
        }

        for(Map.Entry<Integer,Integer> entry : mp.entrySet()){
            if(entry.getValue() == Integer.MAX_VALUE){
                mp.put(entry.getKey(),-1);
            }
        }

        return mp;
    }
}
