class Solution{
    private long totalSum=0,maxProduct=0;
    private static final int MOD=1_000_000_007;

    private long getTotalSum(TreeNode root){
        if(root==null)return 0;
        return root.val+getTotalSum(root.left)+getTotalSum(root.right);
    }

    private long dfs(TreeNode root){
        if(root==null)return 0;
        long leftSum=dfs(root.left);
        long rightSum=dfs(root.right);
        long subTreeSum=root.val+leftSum+rightSum;
        maxProduct=Math.max(maxProduct,subTreeSum*(totalSum-subTreeSum));
        return subTreeSum;
    }

    public int maxProduct(TreeNode root){
        totalSum=getTotalSum(root);
        dfs(root);
        return(int)(maxProduct%MOD);
    }
}
