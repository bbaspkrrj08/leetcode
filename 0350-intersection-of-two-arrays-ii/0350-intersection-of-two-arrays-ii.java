class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> cardi=new HashMap<>();
    for(int num:nums1) {
      cardi.put(num,cardi.getOrDefault(num,0)+1);
    }
    List<Integer> result=new ArrayList<>();
    for(int num:nums2) {
      int freq=cardi.getOrDefault(num, 0);
      if(freq > 0) {
        result.add(num);
        cardi.put(num,freq-1);
      }
    }
    int[]inter=new int[result.size()];
    for(int i=0;i<result.size();i++) {
      inter[i]=result.get(i);
    }
    return inter;
    }
}