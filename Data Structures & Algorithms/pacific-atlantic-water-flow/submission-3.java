class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] nums) {

        int m = nums.length;
        int n = nums[0].length;

        List<List<Integer>> ans = new ArrayList<>();

        // 0 = unknown
        // 1 = currently visiting
        // 2 = can reach ocean
        // 3 = cannot reach ocean
        int[][] pState = new int[m][n];
        int[][] aState = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (dfsP(nums, i, j, pState) &&
                    dfsA(nums, i, j, aState)) {

                    ans.add(List.of(i, j));
                }
            }
        }

        return ans;
    }

    boolean dfsP(int[][] nums, int i, int j, int[][] state) {

        // Reached Pacific
        if (i < 0 || j < 0) {
            return true;
        }

        // Already computed
        if (state[i][j] == 2) {
            return true;
        }

        if (state[i][j] == 3) {
            return false;
        }

        // Cycle
        if (state[i][j] == 1) {
            return false;
        }

        state[i][j] = 1;

        int[][] dirs = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        for (int[] d : dirs) {

            int ni = i + d[0];
            int nj = j + d[1];

            if (ni >= 0 && ni < nums.length &&
                nj >= 0 && nj < nums[0].length &&
                nums[ni][nj] <= nums[i][j]) {

                if (dfsP(nums, ni, nj, state)) {
                    state[i][j] = 2;
                    return true;
                }
            }
            else if (ni < 0 || nj < 0) {
                state[i][j] = 2;
                return true;
            }
        }

        state[i][j] = 3;
        return false;
    }

    boolean dfsA(int[][] nums, int i, int j, int[][] state) {

        // Reached Atlantic
        if (i >= nums.length || j >= nums[0].length) {
            return true;
        }

        // Already computed
        if (state[i][j] == 2) {
            return true;
        }

        if (state[i][j] == 3) {
            return false;
        }

        // Cycle
        if (state[i][j] == 1) {
            return false;
        }

        state[i][j] = 1;

        int[][] dirs = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        for (int[] d : dirs) {

            int ni = i + d[0];
            int nj = j + d[1];

            if (ni >= 0 && ni < nums.length &&
                nj >= 0 && nj < nums[0].length &&
                nums[ni][nj] <= nums[i][j]) {

                if (dfsA(nums, ni, nj, state)) {
                    state[i][j] = 2;
                    return true;
                }
            }
            else if (ni >= nums.length || nj >= nums[0].length) {
                state[i][j] = 2;
                return true;
            }
        }

        state[i][j] = 3;
        return false;
    }
}