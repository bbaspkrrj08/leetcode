class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int MOD = 1_000_000_007;
        int[][] dp = new int[n + 1][minProfit + 1];
        
        dp[0][0] = 1; 
        
        for (int i = 0; i < group.length; i++) {
            int membersNeeded = group[i];
            int currentProfit = profit[i];
            
            for (int j = n; j >= membersNeeded; j--) {
                for (int k = minProfit; k >= 0; k--) {
                    int prevProfit = Math.max(0, k - currentProfit);
                    dp[j][k] = (dp[j][k] + dp[j - membersNeeded][prevProfit]) % MOD;
                }
            }
        }
        
        int totalSchemes = 0;
        for (int j = 0; j <= n; j++) {
            totalSchemes = (totalSchemes + dp[j][minProfit]) % MOD;
        }
        
        return totalSchemes;
    }
}