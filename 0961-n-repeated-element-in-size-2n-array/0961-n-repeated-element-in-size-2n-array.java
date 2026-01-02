class Solution {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            if(!set.contains(num)){
                set.add(num);
            }else{
                return num;
            }
        }
        return 0;
    }
}