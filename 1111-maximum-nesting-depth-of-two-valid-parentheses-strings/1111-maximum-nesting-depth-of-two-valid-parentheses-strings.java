class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int ans[] = new int[seq.length()];
        int depth = 0;
        for(int i=0;i<seq.length();i++){
            char ch = seq.charAt(i);
            if(ch == '('){
                depth+=1;
                ans[i] = depth%2;
            }else if(ch ==')'){
                ans[i] = depth%2;
                depth--;
            }
        }
        return ans;
    }
}