class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> st = new HashSet<>();

        for(int num : nums){
            st.add(num);
        }

        int ans = 0;
        int i = 0;
        while(i<nums.length){
            int num = nums[i];
            if(st.contains(num-1)){
                i++;
                continue;
            }else{
                int count = 0;
                int temp = num;
                while(st.contains(temp)){
                    count++;
                    temp++;
                }
                ans = Math.max(ans,count);
            }
            i++;
        }

        return ans;


    }
}
