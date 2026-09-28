class Solution {
    public int maxDepth(String s) {
        int currDept =0;
        int maxDept =0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                currDept++;
                if(currDept>maxDept){
                    maxDept = currDept;
                }
            }else if(ch == ')'){
                currDept--;
            }
        }
        return maxDept;
    }
}