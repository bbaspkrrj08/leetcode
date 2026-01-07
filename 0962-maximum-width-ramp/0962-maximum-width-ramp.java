class Solution{
    public int maxWidthRamp(int[] nums){
        int n=nums.length;
        int[] maxRight=new int[n];
        maxRight[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--)maxRight[i]=Math.max(maxRight[i+1],nums[i]);
        int ramp=0,i=0,j=0;
        while(j<n){
            while(i<j&&nums[i]>maxRight[j])i++;
            ramp=Math.max(ramp,j-i);
            j++;
        }
        return ramp;
    }
}
