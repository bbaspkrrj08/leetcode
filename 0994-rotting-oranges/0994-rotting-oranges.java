class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]> queue=new LinkedList<>();
        int freshCount=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }else if(grid[i][j]==1){
                    freshCount++;
                }
            }
        }

        if(freshCount==0){
            return 0;
        }

        int minutes=0;
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};

        while(!queue.isEmpty() && freshCount>0){
            int size=queue.size();
            for(int k=0;k<size;k++){
                int[] cur=queue.poll();
                for(int[] d:dirs){
                    int ni=cur[0]+d[0];
                    int nj=cur[1]+d[1];
                    if(ni>=0 && nj>=0 && ni<m && nj<n && grid[ni][nj]==1){
                        grid[ni][nj]=2;
                        freshCount--;
                        queue.offer(new int[]{ni,nj});
                    }
                }
            }
            minutes++;
        }

        return freshCount==0?minutes:-1;
    }
}
