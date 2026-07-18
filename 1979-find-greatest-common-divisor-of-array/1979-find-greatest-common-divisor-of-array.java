class Solution {
    public int findGCD(int[] nums) {
        int ans=0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i:nums){
            max = Math.max(max,i);
            min = Math.min(min,i);
        }
        ans = gcd(min,max);
        return ans;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}