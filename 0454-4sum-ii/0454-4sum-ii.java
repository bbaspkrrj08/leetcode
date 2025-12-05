class Solution {
    public int fourSumCount(int[] A,int[] B,int[] C,int[] D){
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i:A){
            for(int j:B){
                mp.put(i+j,mp.getOrDefault(i+j,0)+1);
            }
        }
        int count=0;
        for(int k:C){
            for(int l:D){
                int target=-(k+l);
                count+=mp.getOrDefault(target,0);
            }
        }
        return count;
    }
}
