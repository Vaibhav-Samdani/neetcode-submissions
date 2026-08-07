class Solution {
    public int singleNumber(int[] nums) {
        int val = 0;

        for(int i: nums){
            val ^= i;
        }

        return val;
    }
}
