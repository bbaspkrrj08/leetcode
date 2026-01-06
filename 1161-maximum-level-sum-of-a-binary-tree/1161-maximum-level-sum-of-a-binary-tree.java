class Solution {
    Map<Integer,Integer> mp=new HashMap<>();
    
    void DFS(TreeNode root,int currLevel){
        if(root==null)return;
        mp.put(currLevel,mp.getOrDefault(currLevel,0)+root.val);
        DFS(root.left,currLevel+1);
        DFS(root.right,currLevel+1);
    }
    
    public int maxLevelSum(TreeNode root) {
        DFS(root,1);
        int mS=Integer.MIN_VALUE;
        int result=1;
        for(Map.Entry<Integer,Integer> it:mp.entrySet()){
            int level=it.getKey();
            int sum=it.getValue();
            if(sum>mS){
                mS=sum;
                result=level;
            }
        }
        return result;
    }
}
