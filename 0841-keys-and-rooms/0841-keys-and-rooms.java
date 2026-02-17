class Solution {
    void dfs(List<List<Integer>> rooms, int u, boolean[] visited) {
        visited[u] = true;
        for (int node : rooms.get(u)) {
            if (!visited[node]) {
                dfs(rooms, node, visited);
            }
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(rooms, 0, visited);
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }
}
