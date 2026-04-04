class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n=nums.length;
        int r=2*k+1;
        int[] ans=new int[n];
        Arrays.fill(ans,-1);
        if(n<2*k+1){
            return ans;
        }
        int idx=0;
        long sum=0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
            ans[idx++]=-1;
        }
        for(int i=k;i<=2*k;i++){
            sum+=nums[i];
        }
        ans[idx++]=(int)(sum/r);
        for(int i=2*k+1;i<n;i++){
            sum+=nums[i];
            sum-=nums[i-2*k-1];
            ans[idx++]=(int)(sum/r);
        }
        return ans;
        
    }
}