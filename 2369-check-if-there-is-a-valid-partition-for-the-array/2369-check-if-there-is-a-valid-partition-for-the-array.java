class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        
        boolean dp0 = true;
        boolean dp1 = false;
        boolean dp2 = n >= 2 && nums[0] == nums[1];
        
        for (int i = 3; i <= n; i++) {
            boolean dp3 = false;
            
            if (nums[i - 1] == nums[i - 2] && dp1) {
                dp3 = true;
            }
            if (nums[i - 1] == nums[i - 2] && nums[i - 2] == nums[i - 3] && dp0) {
                dp3 = true;
            }
            if (nums[i - 1] == nums[i - 2] + 1 && nums[i - 2] == nums[i - 3] + 1 && dp0) {
                dp3 = true;
            }
            
            dp0 = dp1;
            dp1 = dp2;
            dp2 = dp3;
        }
        
        return dp2;
    }
}