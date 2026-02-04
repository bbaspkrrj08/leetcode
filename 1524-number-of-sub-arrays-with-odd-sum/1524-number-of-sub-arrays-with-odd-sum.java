class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod=1000000007;
        int even=1;
        int odd=0;
        int res=0;
        int prefix=0;
        for(int num:arr){
            prefix=prefix+num;
            if(prefix%2==0){
                res=res+odd;
                even++;
            }else{
                res=res+even;
                odd++;
            }
            res=res % mod;
        }
        return res;
    }
}