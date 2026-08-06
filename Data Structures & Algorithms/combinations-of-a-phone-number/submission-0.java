class Solution {
    List<String> ans;

    HashMap<Character, char[]> mp;

    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();

        if (digits.isEmpty()) return ans;
        mp = new HashMap<>();

        mp.put('2', new char[] { 'a', 'b', 'c' });
        mp.put('3', new char[] { 'd', 'e', 'f' });
        mp.put('4', new char[] { 'g', 'h', 'i' });
        mp.put('5', new char[] { 'j', 'k', 'l' });
        mp.put('6', new char[] { 'm', 'n', 'o' });
        mp.put('7', new char[] { 'p', 'q', 'r', 's' });
        mp.put('8', new char[] { 't', 'u', 'v' });
        mp.put('9', new char[] { 'w', 'x', 'y', 'z' });

        solve(digits, new StringBuilder(), 0);

        return ans;
    }

    void solve(String digits, StringBuilder curr, int start) {
        if (start == digits.length()) {
            ans.add(curr.toString());
            return;
        }

        char[] val = mp.get(digits.charAt(start));
        for (int i = 0; i < val.length; i++) {
            curr.append(val[i]);
            solve(digits, curr, start + 1);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
