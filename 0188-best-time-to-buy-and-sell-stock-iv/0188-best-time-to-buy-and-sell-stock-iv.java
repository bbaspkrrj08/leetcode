import java.util.*;

class Solution {
    int[][][] dp;
    int[] nums;
    int k, n;

    public int maxProfit(int k, int[] prices) {
        this.nums = prices;
        this.k = k;
        this.n = prices.length;

        dp = new int[n + 1][2][k + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i][0], -1);
            Arrays.fill(dp[i][1], -1);
        }

        return f(0, 0, 0);
    }

    public int f(int i, int buy, int t) {
        if (i == n || t == k)
            return 0;

        if (dp[i][buy][t] != -1)
            return dp[i][buy][t];

        int c1, c2;

        if (buy == 0)
            c1 = -nums[i] + f(i + 1, 1, t);
        else
            c1 = nums[i] + f(i + 1, 0, t + 1);

        if (buy == 0)
            c2 = f(i + 1, 0, t);
        else
            c2 = f(i + 1, 1, t);

        return dp[i][buy][t] = Math.max(c1, c2);
    }
}