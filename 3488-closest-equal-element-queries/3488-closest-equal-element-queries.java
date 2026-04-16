class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        // Build map: value -> list of indices where it appears
        int i = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, new ArrayList<>());
            }
            map.get(num).add(i);
            i++;
        }

        List<Integer> ans = new ArrayList<>();

        // Process each query (query = index in nums)
        for (int query : queries) {

            List<Integer> list = map.get(nums[query]);

            // If only one occurrence exists, no valid answer
            if (list.size() == 1) {
                ans.add(-1);
            } else {
                int res = Integer.MAX_VALUE;

                // Find position of query index inside the list
                int pos = Collections.binarySearch(list, query);

                // Check next occurrence (forward direction)
                if (pos < list.size() - 1) {
                    res = Math.min(res, list.get(pos + 1) - list.get(pos));
                }

                // Check previous occurrence (backward direction)
                if (pos > 0) {
                    res = Math.min(res, list.get(pos) - list.get(pos - 1));
                }

                // Handle circular case:
                // distance between first and last occurrence via wrap-around
                if (pos == 0 || pos == list.size() - 1) {
                    res = Math.min(res,
                        nums.length - (list.get(list.size() - 1) - list.get(0)));
                }

                ans.add(res);
            }
        }

        return ans;
    }
}