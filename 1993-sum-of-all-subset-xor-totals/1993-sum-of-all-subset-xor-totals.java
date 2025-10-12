class Solution {
    public int subsetXORSum(int[] nums) {
        int n=nums.length;
        int totalSum=0;
        int totalSubsets=(int) Math.pow(2, n);

        for (int ansh=0;ansh<totalSubsets;ansh++) {
            int currentXor=0;
            for (int i=0;i<n;i++) {
                if ((ansh & (1<<i))!=0) {
                    currentXor=currentXor^nums[i];
                }
            }
            totalSum=totalSum+currentXor;
        }

        return totalSum;
    }
}
