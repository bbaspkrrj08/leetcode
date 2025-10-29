class Solution {
    public int smallestNumber(int n) {
        int ansh=1;
        while(ansh<n){
            ansh=ansh<<1|1;
        }
        return ansh;
    }
}