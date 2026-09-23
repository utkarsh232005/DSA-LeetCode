class Solution {
    public int minOperations(int[] nums, int x) {
        int total = 0;
        for (int i : nums) {
            total += i;
        }
        int target = total - x; //11-5 =6
        if (target < 0) {
            return -1;
        }
        int left = 0, sum = 0, longest = -1;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];//1-2-6-
            while (sum > target && left <= right) {
                sum -= nums[left++];//6-1 = 5
            }
            if (sum == target) {
                longest = Math.max(longest, right - left + 1);//max(-1,2-0+1) i:e longest = 3
            }
        }
        if (longest == -1) {
            return -1;
        } else {
            return nums.length - longest;//5-3=2
        }
    }
}