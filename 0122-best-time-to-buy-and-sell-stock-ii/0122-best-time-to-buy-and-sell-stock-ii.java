class Solution {

    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][]dp = new int[n][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return help(0,1,prices,n,dp);
    }

    private int help(int idx, int buy, int[] arr, int n,int [][] dp) {
        if (idx == n)
            return 0;
            if(dp[idx][buy] != -1){
                return dp[idx][buy];
            }
        int profit = 0;
        if (buy == 1) {
            profit = Math.max(-arr[idx] + help(idx + 1, 0, arr, n,dp), 0 + help(idx + 1, 1, arr, n,dp));
        } else {
            profit = Math.max(arr[idx] + help(idx + 1, 1, arr, n,dp), 0 + help(idx + 1, 0, arr, n,dp));
        }
        return dp[idx][buy] = profit;
    }
}