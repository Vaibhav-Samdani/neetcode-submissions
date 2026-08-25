class Solution {
    int[] dp;
    public int climbStairs(int n) {
        dp = new int[n+2];
        int a = 1;

        int b = 2;

        if(n==1) return a;
        if(n==b) return b;

        for(int i = 3; i < n+1 ;i++){
            int c = a + b;
            a = b;
            b = c;
        }

        return b;
    }

}
