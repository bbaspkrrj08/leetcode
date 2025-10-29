class Solution {
    public int countElements(int[] nums) {
        Arrays.sort(nums);
    int beg = -1,end=-1;
    for(int i= 0; i<nums.length-1; i++) {
      if(nums[i+1]>nums[i]) {
        beg=i+1;
        break;
      }
    }
    for(int i=nums.length-1;i>0;i--) {
      if(nums[i-1]<nums[i]) {
        end=i-1;
        break;
      }
    }
    return beg!=-1 && end!=-1?end-beg+1:0;
  }
}
    
