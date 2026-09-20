class Solution {
    public int maxProfit(int[] prices) {
        int mini=prices[0];
        int max = 0;
        int n = prices.length;
        for(int i=1;i<n;i++){
            int cost = prices[i]-mini;
            max = Math.max(cost,max);
            mini = Math.min(prices[i],mini);
        }
        return max;
    }
}