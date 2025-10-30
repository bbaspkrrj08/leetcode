class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
     int ansh=1;
        int akki=0;
        int result=0;
        for(int i=1;i<nums.size();i++){
            if(nums.get(i)>nums.get(i-1)){
                ansh+=1;
            }else{
                akki=ansh;
                ansh=1;
            }
            result = Math.max(result, Math.max(ansh/2,Math.min(ansh,akki)));
        }
        return result;   
    }
}