class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] suf = new int[n];

        suf[n-1] = 1;

        for(int i = 1; i<n;i++){
            suf[n - i - 1] = suf[n- i] * nums[n - i];
        }

        int pre = 1;
        // nums[0] = suf[0];
        for(int i = 0; i<n;i++){
            int or = nums[i];
            nums[i] = pre * suf[i];
            pre *= or;
        }

        return nums;
    }
}  
