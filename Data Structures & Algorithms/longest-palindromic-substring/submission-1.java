class Solution {
    Boolean dp[][];
    public String longestPalindrome(String s) {
        StringBuilder st = new StringBuilder();
        dp = new Boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (check(s, i, j)) {
                    StringBuilder temp = new StringBuilder(s.substring(i, j + 1)) ;
                    if (st.length() < temp.length()) {
                        st = temp;
                    }
                }
            }
        }

        return st.toString();
    }

    boolean check(String s, int i, int j) {
        // Base case
        if (i >= j) {
            return true;
        }

        // Already calculated
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        // Calculate and store
        if (s.charAt(i) != s.charAt(j)) {
            return dp[i][j] = false;
        }

        

        return dp[i][j] = check(s,i+1,j-1);
    }
}
