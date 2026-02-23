class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] i : flights){
            int from = i[0];
            int to = i[1];
            int cost = i[2];
            adj.get(from).add(new int[]{to,cost});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        int[][] dist = new int[n][k+2];
        for(int i=0; i<n; i++){
            for(int j=0; j<k+2; j++){
               dist[i][j] = Integer.MAX_VALUE;
            }
        }
        pq.add(new int[]{src,0,0});
        while(!pq.isEmpty()){
            int[] remove = pq.poll();
            src = remove[0];
            int currDistance = remove[1];
            int stopVar = remove[2];

            if(src == dst) return currDistance;
            if(stopVar > k) continue;
            for(int[] i : adj.get(src)){
                  int nextNode = i[0];
                  int nextDistance = i[1];
                  int newDistance = currDistance + nextDistance;
                  if(newDistance < dist[nextNode][stopVar+1]){
                       dist[nextNode][stopVar+1] = newDistance;
                       pq.add(new int[]{nextNode,newDistance,stopVar+1});
                  }
            }

        }
        return -1;
    }
}