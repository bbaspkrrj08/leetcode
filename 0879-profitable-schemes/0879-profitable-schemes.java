class Solution {
    int MOD = 1_000_000_007;
    int[] group;
    int[] profit;
    Integer[][][] dp; 

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        this.group = group;
        this.profit = profit;
        
        dp = new Integer[group.length][n + 1][minProfit + 1];
        
        return f(0, n, minProfit, 0);
    }

    private int f(int i, int n, int minProfit, int curr_profit) {
        if (i >= profit.length) {
            if (curr_profit >= minProfit) {
                return 1;
            }
            return 0;
        }

        if (dp[i][n][curr_profit] != null) {
            return dp[i][n][curr_profit];
        }

        int take = 0;
        if (n - group[i] >= 0) {
            int next_profit = Math.min(minProfit, curr_profit + profit[i]);
            take = f(i + 1, n - group[i], minProfit, next_profit);
        }

        int skip = f(i + 1, n, minProfit, curr_profit);

        return dp[i][n][curr_profit] = (take + skip) % MOD;
    }
}