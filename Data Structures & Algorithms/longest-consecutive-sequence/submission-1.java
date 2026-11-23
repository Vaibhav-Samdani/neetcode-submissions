class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> st = new HashSet<>();

        for(int num : nums){
            st.add(num);
        }

        int ans = 0;
        for(int num : st){
            if(!st.contains(num-1)){
                int count = 0;
                int temp = num;
                while(st.contains(temp)){
                    count++;
                    temp++;
                }
                ans = Math.max(ans,count);
            }
            
        }

        return ans;


    }
}
