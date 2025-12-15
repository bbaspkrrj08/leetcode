class Solution{
    public int minimumTotal(List<List<Integer>> triangle){
        int n=triangle.size();
        int[] t=new int[n];
        t[0]=triangle.get(0).get(0);

        for(int row=1;row<n;row++){
            for(int col=row;col>=0;col--){
                if(col==0){
                    t[col]=t[col]+triangle.get(row).get(col);
                }else if(col==row){
                    t[col]=t[col-1]+triangle.get(row).get(col);
                }else{
                    t[col]=Math.min(t[col],t[col-1])+triangle.get(row).get(col);
                }
            }
        }

        int minPath=t[0];
        for(int val:t){
            minPath=Math.min(minPath,val);
        }
        return minPath;
    }
}
