class Solution {
    public int numberOfWays(String corridor) {
        int MOD = 1_000_000_007;
        int n = corridor.length();
        int[][] dp = new int[n + 1][3];
        
        dp[n][2] = 1;
        
        for (int i = n - 1; i >= 0; i--) {
            if (corridor.charAt(i) == 'S') {
                dp[i][0] = dp[i + 1][1];
                dp[i][1] = dp[i + 1][2];
                dp[i][2] = dp[i + 1][1];
            } else {
                dp[i][0] = dp[i + 1][0];
                dp[i][1] = dp[i + 1][1];
                dp[i][2] = (dp[i + 1][0] + dp[i + 1][2]) % MOD;
            }
        }
        
        return dp[0][0];
    }
}