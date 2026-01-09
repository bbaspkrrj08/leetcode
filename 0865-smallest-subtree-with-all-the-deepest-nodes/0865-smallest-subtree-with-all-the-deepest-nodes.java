class Solution{
    int maxDepth=-1;
TreeNode result=null;
public TreeNode subtreeWithAllDeepest(TreeNode root) {
    postorder(root,0);
    return result;
}
public int postorder(TreeNode node, int depth) {
    if (node==null) return depth;
    int left=postorder(node.left,depth+1);
    int right=postorder(node.right,depth+1);
    if (left==right){
        maxDepth=Math.max(maxDepth, left);
        if (maxDepth==left) {
            result=node;
        }
    }
    return Math.max(left, right);
}
}