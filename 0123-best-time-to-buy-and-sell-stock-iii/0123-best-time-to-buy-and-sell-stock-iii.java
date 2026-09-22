class Solution {
    public int maxProfit(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n + 1][5];

        for (int idx = n - 1; idx >= 0; idx--) {
            for (int trans = 0; trans < 4; trans++) {
                int profit = 0;
                if (trans % 2 == 0) {
                    profit = Math.max(-arr[idx] + dp[idx + 1][trans + 1], dp[idx + 1][trans]);
                } else {
                    profit = Math.max(arr[idx] + dp[idx + 1][trans + 1], dp[idx + 1][trans]);
                }
                dp[idx][trans] = profit;
            }
        }

        return dp[0][0];
    }
}