class Solution {
    class Pair {
        int i;
        int j;
        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public void islandsAndTreasure(int[][] grid) {
        bfs(grid);
    }

    void bfs(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new Pair(i,j));
                }
            }
        }

        int[][] dis = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };

        while (!q.isEmpty()) {
            Pair node = q.poll();
            int i = node.i;
            int j = node.j;
            int val = grid[i][j];


            for(int[] d : dis){
                int nr = i + d[0];
                int nc = j + d[1];

                if(nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length) continue;

                if(grid[nr][nc] == Integer.MAX_VALUE){
                    grid[nr][nc] = val+1;
                    q.offer(new Pair(nr,nc));
                }
            }
            
        }
    }
}
