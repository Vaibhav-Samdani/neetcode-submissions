class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0;

        int[] freq = new int[26];

        int ans = 0;
        int maxFreq = 0;

        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            freq[ch-'A']++;
            maxFreq = Math.max(maxFreq,freq[ch-'A']);

            while (i < j && (j - i + 1 - maxFreq > k)) {
                freq[s.charAt(i) - 'A']--;
                i++;
            }

            ans = Math.max(j - i + 1, ans);
        }

        return ans;
    }
}
