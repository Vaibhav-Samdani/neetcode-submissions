class Twitter {

    class Tweet {
        int tweetId;
        int time;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    HashMap<Integer, ArrayList<Tweet>> mp;
    int time;
    int[][] followList;

    public Twitter() {
        mp = new HashMap<>();
        time = 0;
        followList = new int[501][501];
    }

    public void postTweet(int userId, int tweetId) {
        if (!mp.containsKey(userId)) {
            mp.put(userId, new ArrayList<>());
        }
        mp.get(userId).add(new Tweet(tweetId, time++));
    }

    public List<Integer> getNewsFeed(int userId) {
        ArrayList<Tweet> curr = new ArrayList<>();

        if (mp.containsKey(userId)) {
            curr.addAll(mp.get(userId));
        }

        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.time, b.time));

        for (int i = 0; i < 501; i++) {
            if (followList[userId][i] == 1 && mp.containsKey(i)) {
                curr.addAll(mp.get(i));
            }
        }

        for (int i = 0; i < curr.size(); i++) {
            pq.offer(curr.get(i));

            if (pq.size() > 10) pq.poll();
        }

        List<Integer> ans = new ArrayList<>();
        int n = pq.size();
        for (int i = 0; i < n; i++) {
            ans.add(pq.poll().tweetId);
        }

        Collections.reverse(ans);
        return ans;
    }

    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        followList[followerId][followeeId] = 1;
    }

    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId) return;

        followList[followerId][followeeId] = 0;
    }
}
/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
