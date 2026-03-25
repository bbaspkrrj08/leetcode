class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, List<String>> memo = new HashMap<>();
        Set<String> dictSet = new HashSet<>(wordDict);
        return dfs(s, dictSet, memo);
    }

    private List<String> dfs(String s, Set<String> dictSet, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        List<String> result = new ArrayList<>();
        if (s.isEmpty()) {
            result.add("");
            return result;
        }

        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            if (dictSet.contains(prefix)) {
                List<String> suffixes = dfs(s.substring(i), dictSet, memo);
                for (String suffix : suffixes) {
                    if (suffix.isEmpty()) {
                        result.add(prefix);
                    } else {
                        result.add(prefix + " " + suffix);
                    }
                }
            }
        }

        memo.put(s, result);
        return result;
    }
}