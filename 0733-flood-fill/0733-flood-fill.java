class Solution {
    static int rowL;
    static int colL;
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};
    public void dfs(int[][] image,boolean[][] vis,int sr,int sc,int color,int prevColor){
        if(sr<0 || sc<0 || sr==rowL || sc==colL || image[sr][sc]!=prevColor){
            return;
        }
        if(vis[sr][sc]){
            return;
        }
        vis[sr][sc]=true;
        prevColor=image[sr][sc];
        image[sr][sc]=color;
        for(int i=0;i<4;i++){
            dfs(image,vis,sr+dr[i],sc+dc[i],color,prevColor);
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rowL=image.length;
        colL=image[0].length;
        boolean[][] vis=new boolean[rowL][colL];
        dfs(image,vis,sr,sc,color,image[sr][sc]);
        return image;

        
    }
}