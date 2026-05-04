class Solution {
    public int lastStoneWeightII(int[] stones) {

        java.util.HashSet<Integer> set = new java.util.HashSet<>();
        set.add(0);

        int total = 0;

        for (int i = 0; i < stones.length; i++) {
            int stone = stones[i];
            total += stone;

            java.util.HashSet<Integer> newSet = new java.util.HashSet<>();

            for (int s : set) {
                newSet.add(s);
                newSet.add(s + stone);
            }

            set = newSet;
        }

        int half = total / 2;
        int s1 = 0;

        for (int s : set) {
            if (s <= half && s > s1) {
                s1 = s;
            }
        }

        return total - 2 * s1;
    }
}