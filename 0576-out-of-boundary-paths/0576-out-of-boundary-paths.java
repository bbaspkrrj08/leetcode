class Solution {
    int mod =(int)1e9+7;
    Integer dp[][][];
    
    public int solve(int i, int j, int move, int m, int n){
        if(i<0 || j<0 || i>=m || j>=n) return 1;
        if(move==0) return 0;
        if(dp[i][j][move]!=null){
            return dp[i][j][move];
        }
        int ans=0;
        ans =(ans+solve(i-1,j,move-1,m,n))%mod;
        ans =(ans+solve(i+1,j,move-1,m,n))%mod;
        ans =(ans+solve(i,j-1,move-1,m,n))%mod;
        ans =(ans+solve(i,j+1,move-1,m,n))%mod;
        return dp[i][j][move]=ans;
    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp=new Integer[m][n][maxMove+1];
        return solve(startRow,startColumn,maxMove,m,n);
    }
}