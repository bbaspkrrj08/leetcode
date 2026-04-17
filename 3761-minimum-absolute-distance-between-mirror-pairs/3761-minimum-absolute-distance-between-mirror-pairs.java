

class Solution {

    public int minMirrorPairDistance(int[] nums) {
        int ans = Integer.MAX_VALUE;
        HashMap<Integer, Integer> mp = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int it = nums[i];

            if (mp.containsKey(it)) {
                ans = Math.min(ans, i - mp.get(it));
            }

            int rev = reverse(it);
            mp.put(rev, i);
        }

        if (ans == Integer.MAX_VALUE) {
            return -1;
        }

        return ans;
    }

    public int reverse(int num) {
        int rev = 0;
        while (num > 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev;
    }
}