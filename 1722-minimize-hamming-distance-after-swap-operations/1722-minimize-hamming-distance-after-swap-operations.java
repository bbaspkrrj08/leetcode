class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        UnionFind uf = new UnionFind(n);
        for (int[] swap : allowedSwaps) {
            uf.union(swap[0], swap[1]);
        }
        
        Map<Integer, List<Integer>> components = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            components.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }
        
        int matches = 0;
        for (List<Integer> group : components.values()) {
            Map<Integer, Integer> srcFreq = new HashMap<>();
            Map<Integer, Integer> tgtFreq = new HashMap<>();
            for (int idx : group) {
                srcFreq.put(source[idx], srcFreq.getOrDefault(source[idx], 0) + 1);
                tgtFreq.put(target[idx], tgtFreq.getOrDefault(target[idx], 0) + 1);
            }
            for (int val : srcFreq.keySet()) {
                if (tgtFreq.containsKey(val)) {
                    matches += Math.min(srcFreq.get(val), tgtFreq.get(val));
                }
            }
        }
        return n - matches;
    }
    
    static class UnionFind {
        int[] parent;
        int[] rank;
        UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) parent[i] = i;
        }
        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
        void union(int x, int y) {
            int rootX = find(x), rootY = find(y);
            if (rootX == rootY) return;
            if (rank[rootX] < rank[rootY]) parent[rootX] = rootY;
            else if (rank[rootX] > rank[rootY]) parent[rootY] = rootX;
            else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}