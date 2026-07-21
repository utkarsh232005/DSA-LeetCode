class Solution {
    public int minCost(int n, int[] cuts) {
        ArrayList<Integer> c = new ArrayList<>();
        for (int cut : cuts) {
            c.add(cut);
        }
        c.add(0);
        c.add(n);
        Collections.sort(c);
        int[][] dp = new int[c.size()][c.size()];
        for (int i = c.size() - 1; i >= 0; i--) {
            for (int j = i + 1; j < c.size(); j++) {
                int minCost = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    int currentCost = c.get(j) - c.get(i);
                    int totalCost = currentCost
                            + dp[i][k]
                            + dp[k][j];

                    minCost = Math.min(minCost, totalCost);
                }
                if (minCost != Integer.MAX_VALUE) {
                    dp[i][j] = minCost;
                }
            }
        }

        return dp[0][c.size() - 1];
    }
}