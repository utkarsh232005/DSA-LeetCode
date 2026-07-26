class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int l = 0, r = 0, count = 0;
        int prod = 1;
        while (r < nums.length) {
            prod *= nums[r];
            while (prod >= k) {
                prod /= nums[l];
                l++;
            }
            count = count + (r - l + 1);
            r++;
        }
        return count;
    }
}