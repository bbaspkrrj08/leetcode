class Graph {
    static class Pair {
        int node, cost;
        Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
    List<List<int[]>> adj;
    public Graph(int n, int[][] edges) {
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];

            adj.get(u).add(new int[]{v, w});
        }
    }

    public void addEdge(int[] edge) {
        int u = edge[0];
        int v = edge[1];
        int w = edge[2];

        adj.get(u).add(new int[]{v, w});
    }

    public int shortestPath(int node1, int node2) {
        int n = adj.size();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);

        pq.offer(new Pair(node1, 0));
        dist[node1] = 0;

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int node = cur.node;
            int cost = cur.cost;

            if (node == node2) return cost;
            if (cost > dist[node]) continue;

            List<int[]> neighbors = adj.get(node);
            for (int i = 0; i < neighbors.size(); i++) {
                int[] next = neighbors.get(i);
                int ne = next[0];
                int newCost = cost + next[1];

                if (newCost < dist[ne]) {
                    dist[ne] = newCost;
                    pq.offer(new Pair(ne, newCost));
                }
            }
        }

        return -1;
    }
}
