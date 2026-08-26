class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int one = 0;
        int two = 0;

        for(int i = n-1; i>=0;i-- ){
            int curr = cost[i] + Math.min(one, two);
            two = one;
            one = curr;
        }

        return Math.min(one,two);
    }
}
