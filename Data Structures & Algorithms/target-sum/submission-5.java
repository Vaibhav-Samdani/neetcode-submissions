class Solution {
    int[][] dp;
    int offset;
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i = 0; i<nums.length;i++){
            sum += nums[i];
        }
        offset = sum;
        dp = new int[2 * sum + 1][nums.length];

        for(int i = 0; i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }

        return solve(nums,target,0);
    }

    int solve(int[] nums, int target, int i){
        if(i == nums.length) return target == 0 ? 1 : 0;

        if(target < -offset || target > offset) return 0;

        if(dp[target+offset][i] != -1) return dp[target+offset][i];

        int p = solve(nums,target-nums[i],i+1);
        int n = solve(nums,target+nums[i],i+1);

        return dp[target+offset][i] = p+n;
    }
}
