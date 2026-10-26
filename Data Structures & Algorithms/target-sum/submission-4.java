class Solution {
    int[][] dp;
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i = 0; i<nums.length;i++){
            sum += nums[i];
        }
        dp = new int[sum+target+1002][nums.length];

        for(int i = 0; i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }

        return solve(nums,target,0);
    }

    int solve(int[] nums, int target, int i){
        if(i == nums.length && target == 0) return 1;
        if(i >= nums.length) return 0;

        if(dp[target+1000][i] != -1) return dp[target+1000][i];

        int p = solve(nums,target-nums[i],i+1);
        int n = solve(nums,target+nums[i],i+1);

        return dp[target+1000][i] = p+n;
    }
}
