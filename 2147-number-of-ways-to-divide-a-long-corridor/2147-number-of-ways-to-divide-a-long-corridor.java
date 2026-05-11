class Solution {
    int MOD = 1_000_000_007;
    String S;
    int n;
    Integer[][] dp;

    public int numberOfWays(String corridor) {
        this.S = corridor;
        this.n = corridor.length();
        this.dp = new Integer[n][3];
        
        return f(0, 0);
    }

    private int f(int i, int seat) {
        if (i >= n) {
            if (seat == 2) {
                return 1;
            }
            return 0;
        }

        if (dp[i][seat] != null) {
            return dp[i][seat];
        }

        long take = 0;
        long not_take = 0;

        if (S.charAt(i) == 'P') {
            if (seat == 2) {
                take = f(i + 1, 0);
                not_take = f(i + 1, seat);
            } else {
                not_take = f(i + 1, seat); 
            }
        } else if (S.charAt(i) == 'S') {
            if (seat == 2) {
                take = f(i + 1, 1);
            } else {
                not_take = f(i + 1, seat + 1);
            }
        }

        return dp[i][seat] = (int) ((take + not_take) % MOD);
    }
}