class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] freq=new int[value];
        for(int x:nums){
            int r=((x% value)+value)% value;
            freq[r]++;
        }
        int want=0;
        while(true){
            int r=want% value;
            if(freq[r]==0) return want;
            freq[r]--;
            want++;


        }
    }
}