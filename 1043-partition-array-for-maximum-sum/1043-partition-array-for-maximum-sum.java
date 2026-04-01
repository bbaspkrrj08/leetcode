class Solution {
public int maxSumAfterPartitioning(int[] arr, int k) {
int n = arr.length;
int[] dp = new int[n + 1];
    dp[n] = 0;
    
    for (int i = n - 1; i >= 0; i--) {
        int ans = 0;
        int maxi = Integer.MIN_VALUE;
        
        for (int j = i; j < i + k && j < n; j++) {
            int len = j - i + 1;
            maxi = Math.max(maxi, arr[j]);
            ans = Math.max(ans, len * maxi + dp[j + 1]);
        }
        
        dp[i] = ans;
    }
    
    return dp[0];
}
}