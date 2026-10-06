class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int ans = Integer.MIN_VALUE;
        // int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            int rowSum[] = new int[matrix[0].length];
            for (int j = i; j < matrix.length; j++) {
                for (int c = 0; c < matrix[0].length; c++) {
                    rowSum[c] += matrix[j][c];
                }
                for (int l = 0; l < matrix[0].length; l++) {
                    int sum = 0;
                    for (int r = l; r < matrix[0].length; r++) {
                        sum += rowSum[r];
                        if (sum <= k) {
                            if (sum > ans) {
                                ans = sum;
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}