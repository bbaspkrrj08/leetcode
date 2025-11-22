class Solution {
    public int numSub(String s) {
        long count=0;
        long track=0;
        long mod=(long)Math.pow(10,9)+7;
        for(char ch : s.toCharArray()){
            if(ch=='1'){
                track++;
            }else{
                count=count+(track*(track+1)/2 % mod)%mod;
                track=0;
            }
        }
        count=count+(track*(track+1)/2 % mod)%mod;

        return (int)count;
        
    }
}