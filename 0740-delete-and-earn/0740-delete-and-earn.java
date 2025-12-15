class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] count=new int[10001];
        for(int v:nums){
            count[v]++;
        }
        int use = 0;
        int avoid = 0;
        int pre = -1;
        for (int i=0;i<=10000;i++){
            if(count[i]>0){
                int max=Math.max(use,avoid);
                if(pre !=i-1){
                    use=i*count[i]+max;
                }else{
                    use=i*count[i]+avoid;
                }
                avoid=max;
                pre=i;
            }
        }
        return Math.max(use, avoid);
    }
}
