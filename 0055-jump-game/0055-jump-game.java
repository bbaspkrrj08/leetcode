class Solution {
    public boolean canJump(int[] nums) {
       int mR=0;
       for(int i=0;i<nums.length;i++){
        if(i>mR) return false;
        mR=Math.max(mR,i+nums[i]);
    }
    return true ;
}
}