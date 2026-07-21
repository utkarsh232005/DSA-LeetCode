class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0;
        long max = 0;
        int l = 0;
        int r = k - 1;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        if (map.size() == k) {
            max = sum;
        }
        while (r < n - 1) {
            map.put(nums[l], map.get(nums[l]) - 1);
            if (map.get(nums[l]) == 0) {
                map.remove(nums[l]);
            }

            sum = sum - nums[l];
            l++;
            r++;
            sum = sum + nums[r];
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            if (map.size() == k) {
                max = Math.max(sum, max);
            }
        }
        return max;
    }
}