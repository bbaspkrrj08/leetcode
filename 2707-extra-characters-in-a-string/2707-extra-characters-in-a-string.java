

class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        Set<String> dictSet = new HashSet<>();
        for (String word : dictionary) {
            dictSet.add(word);
        }

        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j, i);
                if (dictSet.contains(sub)) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }
        return dp[n];
    }
}