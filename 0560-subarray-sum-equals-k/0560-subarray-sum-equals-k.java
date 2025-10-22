class Solution {
    public int subarraySum(int[] nums, int k) {
        int ansh=0;
        int akki=0;
        Map<Integer,Integer> arr_sums=new HashMap();
        arr_sums.put(0,1);
        for(int i=0;i<nums.length;i++){
            ansh+=nums[i];
            if(arr_sums.containsKey(ansh-k)){
                akki+=arr_sums.get(ansh-k);
            }
            arr_sums.put(ansh,arr_sums.getOrDefault(ansh,0)+1);
        }
        return akki;
    }
}