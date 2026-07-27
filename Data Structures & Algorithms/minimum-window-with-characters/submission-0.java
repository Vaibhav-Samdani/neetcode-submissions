class Solution {

    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        int[] need = new int[128];

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            need[ch]++;
        }

        int i = 0;
        int minI = 0, minJ = Integer.MAX_VALUE;
        int count = 0;

        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            need[ch]--;
            if (need[ch] >= 0) {
                count++;
            }

            while (count == t.length()) {
                if ((minJ - minI) > (j - i)) {
                    minI = i;
                    minJ = j;
                }
                char left = s.charAt(i);
                need[left]++;

                if (need[left] > 0) {
                    count--;
                }

                i++;
            }
        }

        if (minJ == Integer.MAX_VALUE) return "";

        return s.substring(minI, minJ + 1);
    }
}