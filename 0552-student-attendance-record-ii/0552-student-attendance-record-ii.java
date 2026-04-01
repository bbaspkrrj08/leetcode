class Solution {
    private static final int MOD = 1_000_000_007;

    public int checkRecord(int n) {
        if (n == 0) return 1;
        
        long[] dp = new long[n + 1];
        dp[0] = 1;
        
        // Proper base cases
        if (n >= 1) dp[1] = 2;  // P, L
        if (n >= 2) dp[2] = 4;  // PP, PL, LP, LL
        
        // Fill rest using recurrence
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % MOD;
        }
        
        long total = dp[n];  // 0 Absent case
        
        // 1 Absent case: 'A' at each position
        for (int i = 0; i < n; i++) {
            long left = dp[i];
            long right = dp[n - 1 - i];
            total = (total + (left * right) % MOD) % MOD;
        }
        
        return (int) total;
    }
}