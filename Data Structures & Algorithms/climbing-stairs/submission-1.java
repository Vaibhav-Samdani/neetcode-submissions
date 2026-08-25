class Solution {
    int[] dp;
    public int climbStairs(int n) {
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,0);
    }

    int solve(int n, int i){
        if(n == i){
            return 1;
        }

        if(n < i){
            return 0;
        }

        if(dp[i] != -1) return dp[i];

        int takeOne = solve(n,i+1);
        int takeTwo = solve(n,i+2);

        return dp[i] = takeOne + takeTwo;
    }
}
