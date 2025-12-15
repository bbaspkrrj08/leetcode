class Solution{
    public int rob(int[] nums){
        int n=nums.length;
        if(n==0)return 0;
        if(n==1)return nums[0];

        int prevPrev=0;
        int prev=nums[0];

        for(int i=2;i<=n;i++){
            int skip=prev;
            int take=nums[i-1]+prevPrev;
            int temp=Math.max(skip,take);
            prevPrev=prev;
            prev=temp;
        }
        return prev;
    }
}
