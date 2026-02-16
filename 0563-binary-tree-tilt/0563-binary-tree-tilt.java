class Solution{
    int sum=0;
    int findSum(TreeNode root){
        if(root==null) return 0;
        int l=findSum(root.left);
        int r=findSum(root.right);
        sum+=Math.abs(l-r);
        return l+root.val+r;
    }
    public int findTilt(TreeNode root){
        findSum(root);
        return sum;
    }
}
