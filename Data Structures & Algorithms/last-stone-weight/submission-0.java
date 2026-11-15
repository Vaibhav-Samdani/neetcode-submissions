class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int i = 0; i < stones.length; i++) {
            pq.offer(stones[i]);
        }

        while(!pq.isEmpty()){
            if(pq.size() == 1) return pq.poll();

            int f = pq.poll();
            int s = pq.poll();

            if(s < f){
                pq.offer(f-s);
            }
        }

        return 0;

    }
}
