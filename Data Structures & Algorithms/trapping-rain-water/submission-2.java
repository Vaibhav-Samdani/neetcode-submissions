class Solution {

    public int trap(int[] arr) {
        int n = arr.length;

        int lMax = 0;
        int rMax = 0;

        int l = 0;
        int r = n - 1;

        int ans = 0;

        while (l < r) {
            if(arr[l] <= arr[r]){
                if(arr[l] < lMax){
                    ans += lMax - arr[l];
                }
                lMax = Math.max(lMax,arr[l]);
                l++;
            }else{
                if(arr[r] < rMax){
                    ans += rMax - arr[r];
                }
                rMax = Math.max(rMax,arr[r]);
                r--;
            }
        }

        return ans;
    }
}
