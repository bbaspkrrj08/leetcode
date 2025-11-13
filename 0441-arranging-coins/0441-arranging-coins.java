class Solution {
    public int arrangeCoins(int n) {
    long begin=0;
    long end=(int)
     Math.sqrt(2*(long) n); 
     while(begin<=end) {
          long mid=(begin+end)/2;
          long coinsUsed=(mid*(mid+1))/2;
          if(coinsUsed==n)
            return(int)mid;
          if(coinsUsed<n){
            begin=mid+1;
          }else{
            end=mid-1;
          }
        }
        return (int) end;
    }
}