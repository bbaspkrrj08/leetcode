class Solution {
    public int numSubarraysWithSum(int[] nums, int k) {
      int n=nums.length;
      int count=0;
      int totalSum=0;
      Map<Integer,Integer> map=new HashMap<>();
      map.put (0,1);
      for(int i=0;i<n;i++){
        totalSum=totalSum+nums[i];
        if(map.containsKey(totalSum-k)){
            count=count+map.get(totalSum-k);
        }
        map.put(totalSum,map.getOrDefault(totalSum,0)+1);
      }  
      return count;
    }
}