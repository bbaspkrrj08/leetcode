class Solution {
    int MOD = 1_000_000_007;
    Integer[][][] dp;
    
    public int checkRecord(int n) {
        dp = new Integer[n + 1][2][3];
        return f(0, n, 0, 0);
    }
    
    private int f(int i, int n, int ab, int l) {
        
        if (i >= n) {
            return 1;
        }
        
        
        if (dp[i][ab][l] != null) {
            return dp[i][ab][l];
        }
        
        
        int c1 = f(i + 1, n, ab, 0);
        
        
        int c2 = 0;
        if (ab == 0) {
            c2 = f(i + 1, n, ab + 1, 0);
        }
        
        
        int c3 = 0;
        if (l < 2) {
            c3 = f(i + 1, n, ab, l + 1);
        }
        
        
        int total = ((c1 + c2) % MOD + c3) % MOD;
        return dp[i][ab][l] = total;
    }
}