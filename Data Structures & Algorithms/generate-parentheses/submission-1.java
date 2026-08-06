class Solution {
    List<String> ans;

    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        solve(n, 0, 0, new StringBuilder());
        return ans;
    }

    void solve(int n, int open, int close, StringBuilder st) {
        

        if (open > n) {
            return;
        }

        if (open < close) {
            return;
        }

        if (n * 2 == st.length()) {
            ans.add(st.toString());
            return;
        }

        st.append('(');
        solve(n, open + 1, close, st);
        st.deleteCharAt(st.length() - 1);

        st.append(')');
        solve(n, open, close + 1, st);
        st.deleteCharAt(st.length() - 1);

    }
}