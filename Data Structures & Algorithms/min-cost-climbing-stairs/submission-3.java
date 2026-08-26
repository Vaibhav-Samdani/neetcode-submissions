class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n + 1];

        for(int i = n-1; i>=0;i-- ){
            int one = dp[i+1];
            int two = i+2 >= n ? 0 :  dp[i+2];

            dp[i] = cost[i] + Math.min(one, two);
        }

        return Math.min(dp[0],dp[1]);
    }
}
