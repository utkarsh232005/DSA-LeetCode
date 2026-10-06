class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        int min = Integer.MAX_VALUE;
        int mSum = 0;
        for (int i = 0; i < n; i++) {
            mSum += nums[i];
            if (mSum < min) {
                min = mSum;
            }
            if (mSum > 0) {
                mSum = 0;
            }
        }
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int cir = total - min;
        if (cir == 0) {
            return max;
        }
        return Math.max(cir, max);
    }
}