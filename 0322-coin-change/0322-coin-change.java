import java.util.*;

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[amount + 1];
        
        q.add(amount);
        visited[amount] = true;
        
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            level++;

            for (int s = 0; s < size; s++) {
                int curr = q.poll();

                for (int coin : coins) {
                    int next = curr - coin;

                    if (next == 0) return level;
                    if (next > 0 && !visited[next]) {
                        visited[next] = true;
                        q.add(next);
                    }
                }
            }
        }
        return -1;
    }
}