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
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    bfs(grid, i, j);
                }
            }
        }
    }

    void bfs(int[][] grid, int x, int y) {
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(x, y));

        while (!q.isEmpty()) {
            Pair node = q.poll();
            int i = node.i;
            int j = node.j;
            int val = grid[i][j];

            if (i > 0 && grid[i - 1][j] != -1 && grid[i - 1][j] != 0 && grid[i - 1][j] > val + 1) {
                q.offer(new Pair(i - 1, j));
                grid[i - 1][j] = Math.min(grid[i - 1][j], val + 1);
            }
            if (j > 0 && grid[i][j - 1] != -1 && grid[i][j - 1] != 0 && grid[i][j - 1] > val + 1) {
                q.offer(new Pair(i, j - 1));
                grid[i][j - 1] = Math.min(grid[i][j - 1], val + 1);
            }
            if (i < grid.length-1 && grid[i + 1][j] != -1 && grid[i + 1][j] != 0
                && grid[i + 1][j] > val + 1) {
                q.offer(new Pair(i + 1, j));
                grid[i + 1][j] = Math.min(grid[i + 1][j], val + 1);
            }
            if (j < grid[0].length-1 && grid[i][j + 1] != -1 && grid[i][j + 1] != 0
                && grid[i][j + 1] > val + 1) {
                q.offer(new Pair(i, j + 1));
                grid[i][j + 1] = Math.min(grid[i][j + 1], val + 1);
            }
        }
    }
}
