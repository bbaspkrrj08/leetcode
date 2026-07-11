class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[][] dp = new int[piles.size()+1][k+1];

        return solve(0 , k , piles.size() , piles , dp);
    }
    public int solve(int i , int k , int n ,List<List<Integer>> piles , int[][] dp ){
        if(i >= n || k == 0) return 0;

        if(dp[i][k] != 0) return dp[i][k];
        int ans =0 ;
        int sum = 0;

        ans = Math.max(ans ,solve(i+1 , k ,n , piles , dp));

        for(int j =0 ; j<piles.get(i).size() ; j++){
            sum += piles.get(i).get(j);
            if(k >= j+1 )
            ans = Math.max(ans , sum + solve(i+1 , k-(j+1) ,n , piles , dp));
        }

        return dp[i][k] = ans;
    }
}