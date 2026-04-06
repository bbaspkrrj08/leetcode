class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i - 1;
        }

        boolean[][] isPal = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || isPal[j + 1][i - 1])) {
                    isPal[j][i] = true;
                    dp[i + 1] = Math.min(dp[i + 1], dp[j] + 1);
                }
            }
        }

        return dp[n];
    }
}