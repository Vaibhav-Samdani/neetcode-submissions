class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2){
            return nums[0] > nums[1] ? nums[1]:nums[0] ;
        }
        int n = nums.length;
        int l = 0;
        int r = n-1;

        if(nums[n-1] > nums[0] && nums[0] < nums[1]) return nums[0];
        if(nums[n-2] > nums[n-1] && nums[0] > nums[n-1]) return nums[n-1];

        while(l < r){
            int mid = l + (r-l)/2;
            if(nums[mid] < nums[mid-1] && nums[mid] < nums[mid+1]) return nums[mid];

            else if(nums[mid] > nums[l]) l = mid;
            else if(nums[mid] < nums[r]) r = mid;
        }
        return -1;
    }
}
