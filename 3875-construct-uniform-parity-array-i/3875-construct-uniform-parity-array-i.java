class Solution {
    public boolean uniformArray(int[] nums1) {
        int n =nums1.length;
        int nums2[] = new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j!=i){
                    nums2[i] = nums1[i]-nums1[j];
                }
            }
        }
        if(nums2.length == n){
            return true;
        }
        return false;
    }
}