class Solution {
    public int lengthOfLongestSubstring(String s) {
      int i = 0;
      Set<Character> st = new HashSet<>();
        int ans = 0;

      for(int j = 0; j<s.length();j++){
        char ch = s.charAt(j);
        while(i<j && st.contains(ch)){
            st.remove(s.charAt(i));
            i++;
        }

        st.add(ch);
        ans = Math.max(ans,st.size());
      }  

      return ans;
    }
}
