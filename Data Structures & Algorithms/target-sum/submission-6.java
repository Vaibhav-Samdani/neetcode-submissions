class Solution {
    public int findTargetSumWays(int[] nums, int t) {
        int sum = 0;
        for (int x : nums) sum += x;
        if (Math.abs(t) > sum) return 0;
        int offset = sum;
        int n = nums.length;
        int W = 2 * sum + 1;
        int[][] dp = new int[n + 1][W];
        dp[n][offset] = 1; // target 0 with 0 numbers left -> 1 way

        for(int i = n-1; i>=0;i--){
            for(int target = -sum; target <= sum;target++){
                int idx = target + offset;
                int ways = 0;
                // if we put +nums[i], we need target-nums[i] from next
                if (target - nums[i] >= -sum && target - nums[i] <= sum) {
                    ways += dp[i + 1][target - nums[i] + offset];
                }
                // if we put -nums[i], we need target+nums[i] from next
                if (target + nums[i] >= -sum && target + nums[i] <= sum) {
                    ways += dp[i + 1][target + nums[i] + offset];
                }
                dp[i][idx] = ways;
            }
        }


        return dp[0][t+offset];
    }

   
}
