class Solution {
    class Pair{
        int node;
        int dist;
        int stop;

        Pair(int node, int dist, int stop){
            this.node = node;
            this.dist = dist;
            this.stop = stop;
        }

    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0; i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i<flights.length;i++){
            int u = flights[i][0];
            int v = flights[i][1];
            int w = flights[i][2];


            adj.get(u).add(new Pair(v,w,0));
        }


        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->
            Integer.compare(a.dist,b.dist)
        );

        int[][] result = new int[n][k+2];
        for(int i = 0; i<n;i++){
            Arrays.fill(result[i],Integer.MAX_VALUE);
        }


        pq.offer(new Pair(src,0,0));

        result[src][0] = 0;

        while(!pq.isEmpty()){
            Pair curr = pq.poll();

            int node = curr.node;
            int dist = curr.dist;
            int stop = curr.stop;

            if(stop > k) continue;

            for(Pair neigh : adj.get(node)){
                int newDist = neigh.dist + dist;
                int newStop = stop + 1;
                if(result[neigh.node][newStop] > newDist){
                    result[neigh.node][newStop] = newDist;
                    pq.offer(new Pair(neigh.node,result[neigh.node][newStop],newStop));
                }
            }

        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i<k+2;i++){
            min = Math.min(min,result[dst][i]);
        }


        return min == Integer.MAX_VALUE ? -1: min;

    }
}
