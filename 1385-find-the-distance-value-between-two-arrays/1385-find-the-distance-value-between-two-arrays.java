class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int ans = 0;
        for (int i = 0; i < arr1.length; i++) {
            int l = 0, r = arr2.length-1;
            boolean valid = true;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (Math.abs(arr1[i] - arr2[mid]) <= d) {
                    valid = false;
                    break;
                } else if (arr2[mid] > arr1[i]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            if (valid) {
                ans++;
            }
        }
        return ans;
    }
}