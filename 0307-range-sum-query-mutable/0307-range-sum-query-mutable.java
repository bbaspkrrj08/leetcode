class NumArray {
    int[] sTree;
    int[] arr;

    public void buildTree(int idx,int left,int right){
        if(left==right){
            sTree[idx]=arr[left];
            return;
        }
        int mid=left+(right-left)/2;
        buildTree(2*idx+1,left,mid);
        buildTree(2*idx+2,mid+1,right);

        sTree[idx]=sTree[2*idx+1]+sTree[2*idx+2];
        
    }

    public void hupdate(int idx,int i,int val,int left,int right){
        if(left==right){
            sTree[idx]=val;
            return; 
        }
        int mid=left+(right-left)/2;
        if(i<=mid){
            hupdate(2*idx+1,i,val,left,mid);
        }else{
            hupdate(2*idx+2,i,val,mid+1,right);
        }
        sTree[idx]=sTree[2*idx+1]+sTree[2*idx+2];
    }

    public int rangeSum(int idx,int left,int right,int qs,int qe){
        if(left>qe || right<qs){
            return  0;
        }
        if(left>=qs && right<=qe){
            return sTree[idx];
        }
        int mid=left+(right-left)/2;
        int l=rangeSum(2*idx+1,left,mid,qs,qe);
        int r=rangeSum(2*idx+2,mid+1,right,qs,qe);
        return l+r;
    }

    public NumArray(int[] nums) {
        int n=nums.length;
        arr=nums.clone();
        sTree=new int[4*n];
        buildTree(0,0,n-1);
        
        
    }
    
    public void update(int index, int val) {
        hupdate(0,index,val,0,arr.length-1);

        
    }
    
    public int sumRange(int left, int right) {
        return rangeSum(0,0,arr.length-1,left,right);
        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */