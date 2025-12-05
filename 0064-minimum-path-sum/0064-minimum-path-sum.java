class Solution {
    int m, n;
    int[][] grid;

    public int minPathSum(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        return solve(0,0);
    }

    private int solve(int i,int j) {
        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                if(r==0&&c==0){}
                else if(r==0) grid[r][c]+=grid[r][c-1];
                else if(c==0) grid[r][c]+=grid[r-1][c];
                else grid[r][c]+=Math.min(grid[r-1][c],grid[r][c-1]);
            }
        }
        return grid[m-1][n-1];
    }
}
