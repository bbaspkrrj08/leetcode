class Solution {
    static int rowL;
    static int colL;
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};
    public class Pair{
        int row;
        int col;
        int h;
        Pair(int row,int col,int h){
            this.row=row;
            this.col=col;
            this.h=h;
        }
    }
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        rowL=grid.size();
        colL=grid.get(0).size();
        int h=0;
        boolean[][] vis=new boolean[rowL][colL];
        vis[0][0]=true;
        PriorityQueue<Pair> q=new PriorityQueue<>((a,b) -> Integer.compare(a.h,b.h));
        if(grid.get(0).get(0)==1){
            q.add(new Pair(0,0,1));
        }else{
            q.add(new Pair(0,0,0));

        }
        
        while(!q.isEmpty()){
            Pair n=q.poll();
            int row=n.row;
            int col=n.col;
            int he=n.h;

            if(row==rowL-1 && col==colL-1 && health-he>0){
                return true;
            }
            
            for(int i=0;i<4;i++){
                int nRow=row+dr[i];
                int nCol=col+dc[i];
                int newH=he;

                if(nRow>=0 && nCol>=0 && nRow<rowL && nCol<colL && !vis[nRow][nCol]){
                    if(grid.get(nRow).get(nCol)==1){
                       newH++;
                    }
                    if(newH<health){
                      vis[nRow][nCol]=true;
                      q.add(new Pair(nRow,nCol,newH));
                    }
                  
                    
                }
            }
        }
        return false;
       
    }
}