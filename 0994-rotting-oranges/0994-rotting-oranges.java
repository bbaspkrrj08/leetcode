class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        int freshCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) return 0;

        int minutes = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty() && freshCount > 0) {
            int size = q.size();
            
            for (int k = 0; k < size; k++) {
                int[] front = q.poll();
                int row = front[0];
                int col = front[1];

                for (int[] d : dirs) {
                    int ni = row + d[0];
                    int nj = col + d[1];

                    if (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] == 1) {
                        grid[ni][nj] = 2;
                        freshCount--;
                        q.offer(new int[]{ni, nj});
                    }
                }
            }
            minutes++;
        }

        if (freshCount == 0) {
            return minutes;
        } else {
            return -1;
        }
    }
}