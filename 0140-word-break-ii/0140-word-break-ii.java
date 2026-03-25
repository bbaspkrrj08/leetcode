class Solution {
    private Set<String> set;
    private List<String>[] memo;
    private int maxLen;
    private String s;
    private int n;

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.n = s.length();
        this.set = new HashSet<>(wordDict);
        this.memo = new ArrayList[n + 1];
        this.maxLen = 0;
        for (String w : wordDict) {
            maxLen = Math.max(maxLen, w.length());
        }

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && (i - j <= maxLen) && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        if (!dp[n]) {
            return new ArrayList<>();
        }

        return dfs(0);
    }

    private List<String> dfs(int start) {
        if (memo[start] != null) {
            return memo[start];
        }

        List<String> result = new ArrayList<>();
        if (start == n) {
            result.add("");
            memo[start] = result;
            return result;
        }

        for (int end = start + 1; end <= n && (end - start) <= maxLen; end++) {
            String word = s.substring(start, end);
            if (set.contains(word)) {
                List<String> subResults = dfs(end);
                for (String sub : subResults) {
                    if (sub.isEmpty()) {
                        result.add(word);
                    } else {
                        result.add(word + " " + sub);
                    }
                }
            }
        }

        memo[start] = result;
        return result;
    }
}