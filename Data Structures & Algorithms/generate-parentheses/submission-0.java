class Solution {

    List<String> ans;

    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();

        solve(n,0,0, new StringBuilder());

        return ans;
    }

    void solve(int n, int open, int close, StringBuilder curr) {
        if (close == n && open == n) {
            ans.add(curr.toString());
            return;
        }

        if(open < n){
            curr.append('(');
            solve(n,open+1,close,curr);
            curr.deleteCharAt(curr.length()-1);
        }

        if(close < open){
            curr.append(')');
            solve(n,open,close+1,curr);
            curr.deleteCharAt(curr.length()-1);
        }
        
        
    }
}
