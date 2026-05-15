class Solution {
    int[] dp;

    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length];
        
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            ans = Math.max(ans, solve(i, nums));
        }
        
        return ans;
    }
    
    private int solve(int i, int[] nums) {
        if (dp[i] != 0) {
            return dp[i];
        }
        
        int ans = 1;
        for(int j = 0; j < i; j++){
            if(nums[j] < nums[i]){
                ans = Math.max(ans, solve(j, nums) + 1);
            }
        }
        
        return dp[i] = ans;
    }
}