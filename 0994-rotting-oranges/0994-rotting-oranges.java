class Solution {
    static int rowL;
    static int colL;
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};
    int maxTime=0;

    static class Pair{
        int row;
        int col;
        int time;
        public Pair(int row,int col,int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
    public int orangesRotting(int[][] grid) {
        rowL=grid.length;
        colL=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<rowL;i++){
            for(int j=0;j<colL;j++){
                if(grid[i][j]==2){
                    //rotten orange
                    q.offer(new Pair(i,j,0));
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0){
            return 0;
        }

        while(!q.isEmpty()){
            Pair curr=q.poll();
            int row=curr.row;
            int col=curr.col;
            int time=curr.time;

            maxTime=Math.max(maxTime,time);

            
            for(int index=0;index<4;index++){
                int nRow=row+dr[index];
                int nCol=col+dc[index];
                if(nRow>=0 && nCol>=0 && nRow<rowL && nCol<colL && grid[nRow][nCol]==1){
                    q.offer(new Pair(nRow,nCol,time+1));
                    grid[nRow][nCol]=2;
                    fresh--;
                }
            }
        }
        return(fresh==0)? maxTime : -1;  
    }
}