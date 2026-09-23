class Solution {
    public int minOperations(int[] nums, int x) {
        int total = 0;
        for(int i : nums){
            total +=i;
        }
        int target = total - x;
        if (target < 0){
            return -1;
        }
        int left = 0, sum = 0, longest = -1;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum > target && left <= right) {
                sum -= nums[left++];
            }
            if (sum == target){
                longest = Math.max(longest, right - left + 1);
            }
        }
        return longest == -1 ? -1 : nums.length - longest;
    }
}