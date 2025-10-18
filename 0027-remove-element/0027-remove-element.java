class Solution {
    public int removeElement(int[] nums, int val) {
        int shiva=0;
        
        for(int i=0;i<nums.length;i++){
            if (nums[i]!=val){
            nums[shiva]=nums[i];
            shiva++;
        }
     }
     return shiva;
    }
}
        
    

