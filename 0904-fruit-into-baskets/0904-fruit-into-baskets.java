class Solution {
    public int totalFruit(int[] nums) {
        int l = 0, r = 0, max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (r < nums.length) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            if (map.size() > 2) {
                while (map.size() > 2) {
                    map.put(nums[l], map.getOrDefault(nums[l], 0) - 1);
                    if (map.get(nums[l]) == 0) {
                        map.remove(nums[l]);
                    }
                    l++;
                }
            }
            if (map.size() <= 2) {
                int len = r - l + 1;
                max = Math.max(len, max);
            }
            r++;
        }
        return max;
    }
}