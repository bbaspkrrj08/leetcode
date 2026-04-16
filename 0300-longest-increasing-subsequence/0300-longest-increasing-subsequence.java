class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> piles = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            
            int ip = Collections.binarySearch(piles, nums[i]);
            if(ip < 0){
                ip = -(ip+1);
                if(ip == piles.size()){
                    piles.add(nums[i]);
                }else{
                    piles.set(ip, nums[i]);
                }
            }
        }

        return piles.size();
    }
}