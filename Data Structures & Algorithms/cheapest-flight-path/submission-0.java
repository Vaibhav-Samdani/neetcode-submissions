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
            int wt = flights[i][2];

            adj.get(u).add(new Pair(v,wt,0));
        }


        int[][] result = new int[n][k+2];

        for(int i = 0; i<n;i++){
        Arrays.fill(result[i],Integer.MAX_VALUE);

        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(a.dist,b.dist));

        pq.offer(new Pair(src,0,0));

        result[src][0] = 0;

        while(!pq.isEmpty()){
            Pair curr = pq.poll();

            // if(result[curr.node] > curr.dist) continue;
            
            if(curr.node == dst) {
                return curr.dist;
            }

            if(curr.stop > k) continue;


            for(Pair neigh : adj.get(curr.node)){
                int newDist = neigh.dist + curr.dist;
                int newStop = curr.stop + 1;
                if(result[neigh.node][newStop] > newDist){
                    result[neigh.node][newStop] = newDist;
                   
                    pq.offer(new Pair(neigh.node,result[neigh.node][newStop], newStop));
                }
            }
        }

        return -1;

    }
}