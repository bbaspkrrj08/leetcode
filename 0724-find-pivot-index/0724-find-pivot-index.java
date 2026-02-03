class Solution {
    public int pivotIndex(int[] arr) {
        int n = arr.length;
        int total=0;
        for (int i=0;i<n;i++){
            total += arr[i];
        }
        int ls=0;
        for (int i=0;i<n;i++){
            int rs=total-ls-arr[i];
            if(ls==rs) return i;
            ls +=arr[i];
        }

        return -1;
    }
}
