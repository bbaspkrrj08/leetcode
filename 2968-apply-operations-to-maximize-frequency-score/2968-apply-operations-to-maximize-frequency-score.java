class Solution {
    public int maxFrequencyScore(int[] nums,long k) {
        int n=nums.length;
        Arrays.sort(nums);
        
        long[] prefix=new long[n];
        prefix[0]=nums[0];
        for (int i=1;i<n;i++) 
            prefix[i]=prefix[i-1]+nums[i];
        
        int min_score=1;
        int max_score=n;
        int result_score=1;
        
        while (min_score<=max_score) {
            int mid=(min_score+max_score)/2;
            
            if (IsPossible(mid,nums,prefix,k,n)) {
                result_score=mid;
                min_score=mid+1;
            } else {
                max_score=mid-1;
            }
        }
        
        return result_score;
    }
    boolean IsPossible(int mid,int[] nums,long[] prefix,long k,int n) {
    for (int i=mid-1;i<n;i++) {
        int start=i-mid+1;
        int m=start+mid/2;
        
        long leftSum=(m>0?prefix[m-1]:0)-(start>0?prefix[start-1]:0);
        long rightSum=prefix[i]-prefix[m];
        
        long leftCost=(long)nums[m]*(m-start)-leftSum;
        long rightCost=rightSum-(long)nums[m]*(i-m);
        
        if (leftCost+rightCost<=k)
            return true;
    }
    return false;
}
}