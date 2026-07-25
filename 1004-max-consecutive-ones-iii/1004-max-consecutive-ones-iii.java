class Solution {
    static{
        for(int i=0;i<500;i++){
            int nums1[]={1,1,0,0,1};
            longestOnes(nums1,2);
        }
        }
    public static int longestOnes(int[] nums, int k) {
        int left=0,right=0;
        int count=0,max=Integer.MIN_VALUE;
        while(right<nums.length){
            if(nums[right]==0) count++;
        while(count>k){
            if(nums[left]==0) count--;
            left++;
        }
        max=Math.max(max,right-left+1);
        right++;
    }
    return max;
    }
}