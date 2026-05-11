class Solution {
    public int numMusicPlaylists(int n, int goal, int k) {
        int MOD = 1_000_000_007;
        long[][] dp = new long[goal + 1][n + 1];
        
        dp[0][0] = 1;
        
        for (int i = 1; i <= goal; i++) {
            for (int j = 1; j <= n; j++) {
                
                long playNewSong = dp[i - 1][j - 1] * (n - j + 1);
                
                long playOldSong = 0;
                if (j > k) {
                    playOldSong = dp[i - 1][j] * (j - k);
                }
                
                dp[i][j] = (playNewSong + playOldSong) % MOD;
            }
        }
        
        return (int) dp[goal][n];
    }
}