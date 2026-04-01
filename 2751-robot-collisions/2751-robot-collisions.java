class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;Arrays.sort(idx, (a, b) -> Integer.compare(positions[a], positions[b]));
    
    List<Integer> stack = new ArrayList<>();
    
    for (int i : idx) {
        if (directions.charAt(i) == 'R') {
            stack.add(i);
        } else {
            while (!stack.isEmpty() && directions.charAt(stack.get(stack.size() - 1)) == 'R' && healths[stack.get(stack.size() - 1)] < healths[i]) {
                stack.remove(stack.size() - 1);
                healths[i]--;
            }
            
            if (!stack.isEmpty() && directions.charAt(stack.get(stack.size() - 1)) == 'R') {
                if (healths[stack.get(stack.size() - 1)] == healths[i]) {
                    stack.remove(stack.size() - 1);
                    healths[i] = 0;
                } else {
                    healths[stack.get(stack.size() - 1)]--;
                    healths[i] = 0;
                }
            }
            
            if (healths[i] > 0) {
                stack.add(i);
            }
        }
    }
    
    Collections.sort(stack);
    List<Integer> ans = new ArrayList<>();
    for (int i : stack) {
        ans.add(healths[i]);
    }
    
    return ans;
}
}