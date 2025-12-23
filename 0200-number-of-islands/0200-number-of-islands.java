class Solution{
    List<int[]>dir=new ArrayList<>();
    public Solution(){
        dir.add(new int[]{1,0});
        dir.add(new int[]{-1,0});
        dir.add(new int[]{0,1});
        dir.add(new int[]{0,-1});
    }
    void dfs(char[][]grid,int i,int j){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]!='1')
            return;
        grid[i][j]='$';
        for(int[]p:dir)
            dfs(grid,i+p[0],j+p[1]);
    }
    public int numIslands(char[][]grid){
        if(grid.length==0)
            return 0;
        int m=grid.length,n=grid[0].length,count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
}
