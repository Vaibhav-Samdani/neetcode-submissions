class Solution {
    int dp[][];
    public String longestPalindrome(String s) {
        StringBuilder st = new StringBuilder();

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
        int mid = i + (j - i) / 2;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
