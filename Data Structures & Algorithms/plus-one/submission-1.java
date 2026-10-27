class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        ArrayList<Integer> ans = new ArrayList<>();
        int idx = n-1;
        int sum = 0;
        int carry = 1;

        while(0 <= idx){
            sum = digits[idx] + carry;
            carry = sum / 10;
            sum = sum % 10;
            ans.add(sum);
            idx--;
        }

        if(carry != 0) ans.add(carry);

        int[] res = new int[ans.size()];

        for(int i = 0; i<ans.size();i++){
            res[ans.size()-i-1] = ans.get(i);
        }

        return res;
        
    }
}
