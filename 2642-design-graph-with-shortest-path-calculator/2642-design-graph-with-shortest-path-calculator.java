class Graph {
    public class DesignGraphWithShortestPathCalculator {
        
    }
List<List<int[]>> adj;
public Graph(int n, int[][] edges) {
       
        adj = new ArrayList<>();
        for(int i=0; i<n; i++)
            adj.add(new ArrayList<>());

        for(int[] edge : edges)
            addEdge(edge);
    }

    public void addEdge(int[] edge) {
        adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
    }

    public int shortestPath(int node1, int node2) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));  
        int n = adj.size();
        int[] costForNode = new int[n];
        Arrays.fill(costForNode, Integer.MAX_VALUE);

        costForNode[node1] = 0;
        pq.offer(new int[]{0, node1});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currCost = curr[0], currNode = curr[1];if(currNode == node2)
                return currCost;

            if(currCost > costForNode[currNode])
                continue;

            for(int[] neighbor : adj.get(currNode)){
                int neighborNode = neighbor[0], neighborCost = neighbor[1];
                int newCost = currCost + neighborCost;

                if(newCost < costForNode[neighborNode]){
                    costForNode[neighborNode] = newCost;
                    pq.offer(new int[]{newCost, neighborNode});
                }
            }
        }

        return -1;
    }
}

