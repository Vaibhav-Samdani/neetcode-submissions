class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int curr = 0;

        for(int i = 0; i<nums.length;i++){
            curr += nums[i];
            sum = Math.max(curr,sum);
            if(curr < 0) curr = 0;

        }
        
        if(sum == 0){
            curr = Integer.MIN_VALUE;
            for(int i = 0; i<nums.length;i++){
                curr = Math.max(curr,nums[i]);
            }
            return curr;
        }

        return sum;

    }
}
