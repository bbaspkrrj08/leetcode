class Solution {
  public int hammingWeight(int n) {
    int ansh=0;
    while (n>0) {
      if ((n&1)==1) {
        ansh++;
      }
      n>>=1;
       }
    return ansh;
  }
}