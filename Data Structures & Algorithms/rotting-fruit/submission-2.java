class Solution {
    class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j));
                }
            }
        }
        int count = -1;
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
            int len = q.size();
            for (int k = 0; k < len; k++) {
                Pair node = q.poll();

                int i = node.i;
                int j = node.j;
                for (int[] d : dir) {
                    int nr = i + d[0];
                    int nc = j + d[1];

                    if (nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length)
                        continue;

                    if (grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        q.offer(new Pair(nr, nc));
                        
                    }
                }
            }

            count++;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return Math.max(count,0);
        // return count;
    }
}
