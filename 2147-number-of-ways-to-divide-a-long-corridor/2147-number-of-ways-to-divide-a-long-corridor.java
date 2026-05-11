class Solution {
    int MOD = 1_000_000_007;
    Integer[][] memo;
    String corridor;
    int n;

    public int numberOfWays(String corridor) {
        this.corridor = corridor;
        this.n = corridor.length();
        this.memo = new Integer[n][3];
        
        return solve(0, 0);
    }

    private int solve(int i, int seats) {
        if (i == n) {
            return seats == 2 ? 1 : 0;
        }

        if (memo[i][seats] != null) {
            return memo[i][seats];
        }

        long ways = 0;
        
        if (seats == 2) {
            if (corridor.charAt(i) == 'S') {
                ways = solve(i + 1, 1); 
            } else {
                int putDivider = solve(i + 1, 0);
                int skipDivider = solve(i + 1, 2);
                ways = (putDivider + skipDivider) % MOD;
            }
        } else {
            if (corridor.charAt(i) == 'S') {
                ways = solve(i + 1, seats + 1);
            } else {
                ways = solve(i + 1, seats);
            }
        }

        return memo[i][seats] = (int) ways;
    }
}