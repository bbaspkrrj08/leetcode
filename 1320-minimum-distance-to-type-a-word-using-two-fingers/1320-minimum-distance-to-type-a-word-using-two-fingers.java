class Solution {
    
    Integer[][][] memo;
    
    public int minimumDistance(String word) {
        int n = word.length();
        memo = new Integer[n][27][27]; // 26 letters + 1 for "null"
        return dfs(word, 0, 26, 26);
    }
    
    private int dfs(String word, int i, int f1, int f2) {
        if (i == word.length()) return 0;
        
        if (memo[i][f1][f2] != null) return memo[i][f1][f2];
        
        int curr = word.charAt(i) - 'A';
        
        // move finger1
        int cost1 = dist(f1, curr) + dfs(word, i + 1, curr, f2);
        
        // move finger2
        int cost2 = dist(f2, curr) + dfs(word, i + 1, f1, curr);
        
        return memo[i][f1][f2] = Math.min(cost1, cost2);
    }
    
    private int dist(int a, int b) {
        if (a == 26) return 0; // null finger
        
        int x1 = a / 6, y1 = a % 6;
        int x2 = b / 6, y2 = b % 6;
        
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}