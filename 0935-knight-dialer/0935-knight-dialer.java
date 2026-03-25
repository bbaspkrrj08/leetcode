class Solution {
    int mod = 1_000_000_007;
    public int knightDialer(int n) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0 ; i<10 ; i++){
            list.add(new ArrayList<>());
        }

        list.get(0).addAll(Arrays.asList(4,6));
        list.get(1).addAll(Arrays.asList(6,8));
        list.get(2).addAll(Arrays.asList(7,9));
        list.get(3).addAll(Arrays.asList(4,8));
        list.get(4).addAll(Arrays.asList(0,3,9));
        list.get(6).addAll(Arrays.asList(0,1,7));
        list.get(7).addAll(Arrays.asList(2,6));
        list.get(8).addAll(Arrays.asList(1,3));
        list.get(9).addAll(Arrays.asList(2,4));

        int ans = 0;
        int[][] dp = new int[10][n+1];
        for(int[] d : dp){
            Arrays.fill(d , -1);
        }
        for(int i=0 ; i<10 ; i++){
            ans = (ans + solve(i , list , 1 , n , dp))%mod;
        }
        return ans;
    }
    public int solve(int i , ArrayList<ArrayList<Integer>> list , int curr_len , int len , int[][] dp){
        if(len == curr_len){
            return 1;
        }

        if(dp[i][curr_len] != -1) return dp[i][curr_len];
        int ans = 0;
        for(int num : list.get(i)){
            ans = (ans + solve(num , list , curr_len +1, len , dp))%mod;
        }

        return dp[i][curr_len] = ans;
    }
}