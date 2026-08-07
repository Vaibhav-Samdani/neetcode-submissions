class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0;
        int xorOfArray = 0;

        for(int i = 0; i < nums.length;i++){
            xor ^= i;
            xorOfArray ^= nums[i];
        }

        xor ^= nums.length;

        return xor ^ xorOfArray;

    }
}
