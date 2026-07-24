class Solution {

    public int maxArea(int[] nums) {
        int ans = 0;
        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            int val = (j - i) * Math.min(nums[j], nums[i]);
            ans = Math.max(val, ans);

            if (nums[j] < nums[i]) {
                j--;
            } else {
                i++;
            }
        }

        return ans;
    }
}
