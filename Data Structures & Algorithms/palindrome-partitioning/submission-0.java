class Solution {
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();

        solve(s,0,new ArrayList<>());

        return ans; 
    }

    void solve(String s, int start, List<String> curr) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String sb = s.substring(start,i+1);
            if(isPalindrome(sb)){
                curr.add(sb);
                solve(s,i+1,curr);
                curr.remove(curr.size()-1);
            }
        }
    }

    boolean isPalindrome(String s){
        if(s.length()==1||s.length()==0) return true;

        for(int i = 0; i<s.length()/2;i++){
            if(s.charAt(i) != s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}
