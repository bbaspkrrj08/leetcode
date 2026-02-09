class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(root, targetSum, path, ans);
        return ans;
    }

    private void helper(TreeNode root, int sum,
                        List<Integer> path,
                        List<List<Integer>> ans) {

        if (root == null) return;

        path.add(root.val);
        sum -= root.val;

        if (root.left == null && root.right == null) {
            if (sum == 0) {
                ans.add(new ArrayList<>(path));
            }
        } else {
            helper(root.left, sum, path, ans);
            helper(root.right, sum, path, ans);
        }

        path.remove(path.size() - 1);
    }
}
