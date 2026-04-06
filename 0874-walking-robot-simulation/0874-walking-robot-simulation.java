class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] dirs = {0, 1, 0, -1, 0};
        
        
        Set<Integer> obstacleSet = new HashSet<>();
        for (int[] obs : obstacles) {
            obstacleSet.add(obs[0] * 60010 + obs[1]);
        }
        
        int maxDist = 0, x = 0, y = 0, dirIdx = 0;
        
        for (int cmd : commands) {
            if (cmd == -2) {
                dirIdx = (dirIdx + 3) % 4;
            } else if (cmd == -1) {
                dirIdx = (dirIdx + 1) % 4;
            } else {
                for (int i = 0; i < cmd; i++) {
                    int nx = x + dirs[dirIdx];
                    int ny = y + dirs[dirIdx + 1];
                    
                    if (obstacleSet.contains(nx * 60010 + ny)) {
                        break;
                    }
                    
                    x = nx;
                    y = ny;
                    maxDist = Math.max(maxDist, x * x + y * y);
                }
            }
        }
        
        return maxDist;
    }
}