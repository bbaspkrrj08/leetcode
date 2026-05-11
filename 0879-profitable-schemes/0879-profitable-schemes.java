class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int MOD = 1_000_000_007;
        int[][] dp = new int[n + 1][minProfit + 1];
        
        dp[0][0] = 1; 
        
        for (int i = 0; i < group.length; i++) {
            int m = group[i];
            int p = profit[i];
            
            for (int j = n; j >= m; j--) {
                for (int k = minProfit; k >= 0; k--) {
                    int rem = Math.max(0, k - p);
                    dp[j][k] = (dp[j][k] + dp[j - m][rem]) % MOD;
                }
            }
        }
        
        int ans = 0;
        for (int j = 0; j <= n; j++) {
            ans = (ans + dp[j][minProfit]) % MOD;
        }
        
        return ans;
    }
}