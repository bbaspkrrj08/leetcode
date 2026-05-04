import java.util.*;

class Solution {
    public int lastStoneWeightII(int[] stones) {
        Set<Integer> set = new HashSet<>();
        set.add(0);

        int total = 0;

        for (int stone : stones) {
            total += stone;

            Set<Integer> newSet = new HashSet<>(set);

            for (int s : set) {
                newSet.add(s + stone);
            }

            set = newSet;
        }

        int half = total / 2;
        int closest = 0;

        for (int s : set) {
            if (s <= half) {
                closest = Math.max(closest, s);
            }
        }

        return total - 2 * closest;
    }
}