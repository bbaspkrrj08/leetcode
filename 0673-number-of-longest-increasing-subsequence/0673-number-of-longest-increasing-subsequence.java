class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        
        int[] lengths = new int[n];
        int[] counts = new int[n];
        
        java.util.Arrays.fill(lengths, 1);
        java.util.Arrays.fill(counts, 1);
        
        int maxLength = 1;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (lengths[j] + 1 > lengths[i]) {
                        lengths[i] = lengths[j] + 1;
                        counts[i] = counts[j];
                    } else if (lengths[j] + 1 == lengths[i]) {
                        counts[i] += counts[j];
                    }
                }
            }
            maxLength = Math.max(maxLength, lengths[i]);
        }
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (lengths[i] == maxLength) {
                ans += counts[i];
            }
        }
        
        return ans;
    }
}