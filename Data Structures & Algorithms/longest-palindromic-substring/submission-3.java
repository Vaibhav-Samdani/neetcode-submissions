class Solution {
    Boolean dp[][];

    public String longestPalindrome(String s) {
        dp = new Boolean[s.length()][s.length()];
        int start = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {

            int odd = check(s, i, i);
            int even = check(s, i, i + 1);

            int len = Math.max(odd, even);

            if (len > maxLen) {
                start = i - (len - 1) / 2;
                maxLen = len;
            }

        }

        return s.substring(start, start + maxLen);

    }

    int check(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }

        return j - i - 1;
    }
}
