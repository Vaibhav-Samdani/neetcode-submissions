class Solution {
    int[][] dp;

    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;

        dp = new int[coins.length + 1][amount + 1];

        // Base conditions;
        for (int i = 0; i < amount+1; i++) {
            dp[0][i] = 100_000_000;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
               
                int take = coins[i - 1] <= j ? 1 + dp[i][j - coins[i-1]] : 100_000_000;
                int notTake = dp[i-1][j];

                dp[i][j] = Math.min(take, notTake);
            }
        }

        int ans = dp[coins.length][amount];

        return ans >= 100_000_000 ? -1 : ans;
    }

}