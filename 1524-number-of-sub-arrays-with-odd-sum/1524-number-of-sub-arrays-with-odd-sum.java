class Solution{
public int numOfSubarrays(int[] arr){
int mod=1000000007;
java.util.Map<Integer,Long> map=new java.util.HashMap<>();
map.put(0,1L);
long res=0;
int prefix=0;
for(int num:arr){
prefix+=num;
int parity=prefix%2;
int need=parity==0?1:0;
res+=map.getOrDefault(need,0L);
map.put(parity,map.getOrDefault(parity,0L)+1);
res%=mod;
}
return(int)res;
}
}
