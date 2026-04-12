class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int count=0;
        for(int num : nums){
            if(num==0 && digit==0){
                count++;
                continue;
            }
            while(num>0){
                int d=num%10;
                if(d==digit){
                    count++;
                }
                num/=10;
            }
        }
        return count;
        
        
    }
}