class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        
        HashMap<Integer, Integer> hm=new HashMap<>();
        for(int x:nums){
            hm.put(x, hm.getOrDefault(x, 0)+1);
        }
        List<Integer> ls=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1])continue;
            int max=Math.min(k, hm.get(nums[i]));
            for(int p=0;p<max;p++){
                ls.add(nums[i]);
            }
        }
        int[] arr=new int[ls.size()];
        for(int i=0;i<ls.size();i++){
            arr[i]=ls.get(i);
        }
        return arr;
    }
}