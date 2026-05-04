class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += stones[i];
        }

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for(int i = 0; i < n; i++) {
            for(int j = sum; j >= stones[i]; j--) {
                dp[j] = dp[j] || dp[j - stones[i]];
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i <= sum / 2; i++) {
            if(dp[i]) {
                ans = Math.min(ans, sum - 2 * i);
            }
        }

        return ans;
    }
}