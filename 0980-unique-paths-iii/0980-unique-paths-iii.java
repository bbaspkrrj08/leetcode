class Solution {
    int nonObstacleCount;
    int ans;
    int[][] grid;
    int m;
    int n;

    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;

        nonObstacleCount = 1;
        ans = 0;

        int start_i = 0;
        int start_j = 0;

        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] == 0) nonObstacleCount++;
                if(grid[i][j] == 1){
                    start_i = i;
                    start_j = j;
                }
            }   
        }
        backtrack(0,start_i,start_j);
        return ans;
    }
    void backtrack(int count, int i ,int j){
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j] == -1) return;
        if(grid[i][j] == 2){
            if(count == nonObstacleCount){
                ans++;
                return;
            }
        }
        int temp = grid[i][j];
        grid[i][j] = -1;
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        for(int[] d:dir) backtrack(count+1,i+d[0],j+d[1]);
        grid[i][j] = temp;
    }
}