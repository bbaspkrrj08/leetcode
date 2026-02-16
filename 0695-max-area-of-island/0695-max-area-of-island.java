class Solution {
    static int rowL;
    static int colL;
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};

    public int dfs(int[][] grid,boolean[][] vis,int i,int j){
        if(i<0 || j<0 || i==rowL || j==colL || grid[i][j]==0){
            return 0;
        }
        if(vis[i][j]==true){
            return 0;
        }
        vis[i][j]=true;
        int len=1;
        for(int index=0;index<4;index++){
            len+=dfs(grid,vis,i+dr[index],j+dc[index]);
        }
        return len;
    }
    public int maxAreaOfIsland(int[][] grid) {
        rowL=grid.length;
        colL=grid[0].length;
        boolean[][] vis=new boolean[rowL][colL];
        int max=0;
        for(int i=0;i<rowL;i++){
            for(int j=0;j<colL;j++){
                if(grid[i][j]==1){
                    max=Math.max(max,dfs(grid,vis,i,j));

                }
            }
        }
        return max;
        
    }
}