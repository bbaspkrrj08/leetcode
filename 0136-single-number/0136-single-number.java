class Solution {
    public int singleNumber(int[] nums) {
       int ansh=0;
       for(int akki=0;akki<nums.length;akki++){
        ansh^=nums[akki];
       } 
       return ansh;
    }
}