import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums2[j] < nums1[i]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int ans[] = new int[set.size()];
        int k = 0;
        for (int l : set) {
            ans[k++] = l;
        }
        return ans;
    }
}