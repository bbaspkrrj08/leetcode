class Solution {
    public boolean canJump(int[] nums) {
        int lakshya =0;
        for(int i=0;i<nums.length;i++){
            if(i>lakshya){
                return false;
            }
            lakshya=Math.max(lakshya,i+nums[i]);
        }
        return true;
    }
}