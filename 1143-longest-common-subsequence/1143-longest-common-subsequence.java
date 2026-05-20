class Solution {
    Integer[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new Integer[text1.length()][text2.length()];
        return LCS(0 , 0 , text1 , text2);
    }
    public int LCS(int i , int j , String a , String b){
        if(i == a.length() || j== b.length()){
            return 0;
        }
        if(dp[i][j] != null) return dp[i][j];
        int take = 0;
        if(a.charAt(i) == b.charAt(j)){
            take = 1 + LCS(i+1 , j+1 , a , b);
        }

        int skip1 = LCS(i+1 , j , a , b);
        int skip2 = LCS(i , j+1 , a , b);

        return dp[i][j] = Math.max(take , Math.max(skip1 , skip2));
    }
}