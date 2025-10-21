class Solution {
    public int largestAltitude(int[] gain) {
        int ansh=0;
        int akki=0;
        for(int val:gain){
            ansh+=val;
            akki=Math.max(ansh,akki);
        }
        return akki;
    }
}