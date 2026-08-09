class Solution {
    class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] nums) {
        int m = nums.length, n = nums[0].length;
        boolean[][] pVis = new boolean[m][n];
        boolean[][] aVis = new boolean[m][n];
        atlanticBfs(nums, aVis);
        pacificBfs(nums, pVis);

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(pVis[i][j] && aVis[i][j]){
                    List<Integer> curr = new ArrayList<>();
                    curr.add(i);
                    curr.add(j);
                    ans.add(new ArrayList<>(curr));
                }
            }
        }

        return ans;
    }

    void atlanticBfs(int[][] nums, boolean[][] vis){

        int m = nums.length;
        int n = nums[0].length;
        Queue<Pair> q = new LinkedList<>();

        for(int i = n-1; i >=0;i--){
            q.offer(new Pair(m-1,i));
            vis[m-1][i] = true;
        }
        for(int i = m-1; i >= 0;i--){
            q.offer(new Pair(i,n-1));
            vis[i][n-1] = true;
        }

        while(!q.isEmpty()){
            int len = q.size(); 

            for(int k = 0; k<len;k++){
                Pair node = q.poll();

                int i = node.i;
                int j = node.j;

                if(i > 0 && !vis[i-1][j] && nums[i-1][j] >= nums[i][j]){
                    vis[i-1][j] = true;
                    q.offer(new Pair(i-1,j));
                }
                if(j > 0 && !vis[i][j-1] && nums[i][j-1] >= nums[i][j]){
                    vis[i][j-1] = true;
                    q.offer(new Pair(i,j-1));
                }

                if(i < nums.length-1 && !vis[i+1][j] && nums[i+1][j] >= nums[i][j]){
                    vis[i+1][j] = true;
                    q.offer(new Pair(i+1,j));
                }
                if(j < nums[0].length-1 && !vis[i][j+1] && nums[i][j+1] >= nums[i][j]){
                    vis[i][j+1] = true;
                    q.offer(new Pair(i,j+1));
                }
            }
        }
    }

    void pacificBfs(int[][] nums, boolean[][] vis){
        Queue<Pair> q = new LinkedList<>();

        for(int i = 0; i < nums[0].length;i++){
            q.offer(new Pair(0,i));
            vis[0][i] = true;
        }
        for(int i = 1; i < nums.length;i++){
            q.offer(new Pair(i,0));
            vis[i][0] = true;
        }

        while(!q.isEmpty()){
            int len = q.size(); 

            for(int k = 0; k<len;k++){
                Pair node = q.poll();

                int i = node.i;
                int j = node.j;

                if(i < nums.length-1 && !vis[i+1][j] && nums[i+1][j] >= nums[i][j]){
                    vis[i+1][j] = true;
                    q.offer(new Pair(i+1,j));
                }
                if(j < nums[0].length-1 && !vis[i][j+1] && nums[i][j+1] >= nums[i][j]){
                    vis[i][j+1] = true;
                    q.offer(new Pair(i,j+1));
                }

                if(i > 0 && !vis[i-1][j] && nums[i-1][j] >= nums[i][j]){
                    vis[i-1][j] = true;
                    q.offer(new Pair(i-1,j));
                }
                if(j > 0 && !vis[i][j-1] && nums[i][j-1] >= nums[i][j]){
                    vis[i][j-1] = true;
                    q.offer(new Pair(i,j-1));
                }
            }
        }
    }
}