class Solution {

    public int leastInterval(char[] tasks, int n) {
        int[] mp = new int[26];

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int i = 0; i < tasks.length; i++) {
            mp[tasks[i] - 'A']++;
        }

        for (int i = 0; i < 26; i++) {
            if (mp[i] > 0) pq.offer(mp[i]);
        }

        int time = 0;

        while (!pq.isEmpty()) {
            ArrayList<Integer> curr = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                if (!pq.isEmpty()) {
                    int freq = pq.poll();

                    freq--;

                    curr.add(freq);
                }
            }
            for (int i = 0; i < curr.size(); i++) {
                int val = curr.get(i);
                if (val > 0) pq.offer(val);
            }
            if (pq.isEmpty()) {
                time += curr.size();
            } else {
                time += n + 1;
            }
        }

        return time;
    }
}
