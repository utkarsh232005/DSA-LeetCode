class Solution {
    public long sumAndMultiply(int n) {
        if (n == 0) return 0;
        int num = Math.abs(n);
        long ans =0;
        int sum =0;
        StringBuilder sb = new StringBuilder();
        while(num!=0){
            int x =0;
            int temp = num%10;
            if(temp!=0){
                x=temp;
                sum+=x;
                sb.append(x);
            }
            num/=10;
        }
        if (sb.length() == 0) return 0;
        sb.reverse();
        long x = Integer.parseInt(sb.toString());
        ans = Math.abs(x*sum);
        return ans;
    }
}