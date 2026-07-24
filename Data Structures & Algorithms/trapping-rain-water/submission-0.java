class Solution {
    public int trap(int[] nums) {
        // ( right - left ) * min(nums[left], nums[right]) - sum; 
        // int val = Math.min(nums[i],nums[max]) * (i-max-1) - currSum;
        if (nums.length == 0) return 0;
        int ans = 0;

        int left = 0;
        int right = nums.length-1;
        int lmax = nums[0];
        int rmax = nums[nums.length-1];

        while(left < right){
            if(lmax <= rmax){
                left++;
                lmax = Math.max(lmax,nums[left]);
                ans += lmax - nums[left];
            }else{
                right--;
                rmax = Math.max(rmax,nums[right]);
                ans += rmax - nums[right];
            }

        }

        return ans;
    }
}