class Solution {
    int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        int ans = 0;
        int m = matrix.length, n = matrix[0].length;
         dp = new int[m][n];

        for(int i = 0; i<m;i++){
            Arrays.fill(dp[i],-1);
        }

        for(int i = 0; i<m;i++){
            for(int j = 0; j<n;j++){
                ans = Math.max(ans,solve(matrix,i,j));
            }
        }
        return ans;
    }

    int solve(int[][] matrix, int i, int j){
        if(i >= matrix.length || i < 0 || j >= matrix[0].length || j < 0){
            return 0;
        }

        if(dp[i][j] != -1) return dp[i][j];

        int currAns = 1;

        if(i+1 < matrix.length && matrix[i+1][j] > matrix[i][j]){
            currAns = 1 + solve(matrix,i+1,j);
        }
        if(j+1 < matrix[0].length && matrix[i][j+1] > matrix[i][j]){
            currAns = Math.max(currAns, 1 + solve(matrix,i,j+1));
        }

        if(j-1 >= 0 && matrix[i][j-1] > matrix[i][j]){
            currAns = Math.max(currAns, 1 + solve(matrix,i,j-1));
        }
        if(i-1 >= 0 && matrix[i-1][j] > matrix[i][j]){
            currAns = Math.max(currAns, 1 + solve(matrix,i-1,j));
        }

        return dp[i][j] = currAns;

    }

}
