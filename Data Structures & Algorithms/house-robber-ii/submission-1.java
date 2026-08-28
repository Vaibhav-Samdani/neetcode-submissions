class Solution {
    int[] dp;

    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n+2];
        Arrays.fill(dp, 0);

        // if (n <= 3) {
        //     int ans = 0;
        //     for (int i = 0; i < n; i++) {
        //         ans = Math.max(nums[i], ans);
        //     }

        //     return ans;
        // }

        if (n == 1) return nums[0];

        int first = solve(nums, 0, n - 2);
        Arrays.fill(dp, 0);
        int second = solve(nums, 1, n-1);

        return Math.max(first, second);
    }

    int solve(int[] nums, int s, int n) {
       
        for (int i = n; i >= s; i--) {
            int take = nums[i] + dp[i + 2];
            int notTake = dp[i + 1];

            dp[i] = Math.max(take, notTake);
        }
        return dp[s];
    }
}
