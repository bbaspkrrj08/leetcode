class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        
        rotate(nums, 0, n-1-k);
        rotate(nums, n-k, n-1);
        
        rotate(nums, 0, n-1);
    }
    
    private void rotate(int[] arr, int start, int end){
        while(start<end){
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            
            ++start; --end;
        }
    }
}