class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int result[] = new int[n];
        Arrays.fill(result,Integer.MAX_VALUE);
        
        result[src] = 0;


        for(int i = 0; i <= k; i++){
            int[] temp = Arrays.copyOf(result,n);
            for(int[] edge : flights){
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];

                if(result[u] == Integer.MAX_VALUE) continue;
                if(result[u] + w < temp[v]){
                    temp[v] = result[u] + w;
                }
            }
            result = temp;
        }

        return result[dst] == Integer.MAX_VALUE? -1: result[dst];
    }
}