class Solution {
    public double minimumAverage(int[] nums) {
        int count = nums.length/2;
        float[] averages = new float[nums.length/2];
        Arrays.sort(nums);
        int slow = 0, fast = nums.length-1, index = 0;
        while(count>0){
            averages[index] = (float)(nums[slow] + nums[fast])/2;
            count--;
            slow++;
            fast--;
            index++;
        }
        Arrays.sort(averages);
        return averages[0];
    }
}