class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] arr = new int[n];
        int sum = 0;

        for(int i = 0; i<n;i++){
            arr[i] = gas[i]-cost[i];
            sum += arr[i];
        }

        if(sum < 0) return -1;
        
        int prefix = 0;
        int ans = 0;
        for(int i = 0; i<n;i++){
            prefix += arr[i];

            if(prefix < 0){
                prefix = 0;
                ans = i+1;
            }
        }

        return ans;
     }
}
