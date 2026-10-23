class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int pre = 1;

        for(int i = 0; i<n;i++){
            // int curr = nums[i];
            ans[i] = pre;
            pre *= nums[i];
        }

        int suff = 1;
        // nums[0] = suf[0];
        for(int i = n-1; i >= 0;i--){
          ans[i] *= suff;
          suff *= nums[i];
        }

        return ans;
    }
}  
