class Solution {
    Boolean[] dp;

    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new Boolean[s.length()];
        return f(0, s, new HashSet<>(wordDict));
    }

    public boolean f(int i, String string, HashSet<String> set) {
        int n = string.length();
        if(i == n) return true;

        if(dp[i] != null) return dp[i];

        String temp = "";
        boolean ans = false;

        for(int j = i; j < n; j++){
            temp += string.charAt(j);
            if(set.contains(temp))
                ans = ans || f(j + 1, string, set);
        }

        return dp[i] = ans;
    }
}