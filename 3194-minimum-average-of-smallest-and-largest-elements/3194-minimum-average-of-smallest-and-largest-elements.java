class Solution {
    public double minimumAverage(int[] nums) {
        double min=Integer.MAX_VALUE;
        Arrays.sort(nums);
        int left=0;
        int right=nums.length-1;
        while(left<right){
            double  curr=(nums[left]+nums[right])/2.0;
            min=(double)Math.min(min,curr);
            left++;
            right--;
        }
        return min;
        
        
    }
}