class Solution {
    public int countValidSelections(int[] nums) {
        int ansh=nums.length;
        int akki=0;
        int[] sf=new int[ansh+1];
        for(int i=1;i<=ansh;i++){
            sf[i]=sf[i-1]+nums[i-1];
            }
        for(int i=0;i<ansh;i++){
            if(nums[i]==0){
                int leftSum=sf[i];
                int rightSum=sf[ansh]-sf[i+1];
                if(leftSum==rightSum){
                    akki +=2;
                }else if(Math.abs(leftSum-rightSum)==1){
                    akki +=1;
                }
            } 
            }   
return akki;
       
    }
}