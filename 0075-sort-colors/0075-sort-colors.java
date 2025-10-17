class Solution{
public void sortColors(int[] nums){
if(nums.length==0||nums.length==1)return;
int start=0,end=nums.length-1,index=0;
while(index<=end&&start<end){
if(nums[index]==0){
int temp=nums[start];
nums[start]=nums[index];
nums[index]=temp;
start++;
index++;
}else if(nums[index]==2){
int temp=nums[end];
nums[end]=nums[index];
nums[index]=temp;
end--;
}else index++;
}
}
}
