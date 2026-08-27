class Solution {
    int[] dp;

    public int rob(int[] nums) {
        int n = nums.length;
        int a = 0;
        int b = 0;

        for (int i = n - 1; i >= 0; i--) {
            int curr = Math.max(nums[i] + b, a);
            b = a;
            a = curr;
        }
        
        return a;
    }
}