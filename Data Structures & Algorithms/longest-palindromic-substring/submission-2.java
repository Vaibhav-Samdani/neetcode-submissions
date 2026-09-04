class Solution {
    Boolean dp[][];
    public String longestPalindrome(String s) {
        dp = new Boolean[s.length()][s.length()];
        int start = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (check(s, i, j)) {
                    int len = j - i + 1;

                    if (len > maxLen) {
                        start = i;
                        maxLen = len;
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);
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
