class Solution {
    public int[] shortestToChar(String s, char c) {
        List<Integer> indexs = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == c){
                indexs.add(i);
            }
        }
        for(int i=0;i<s.length();i++){
            int min = 10000;
            for(int j : indexs){
                min = Math.min(min,Math.abs(j-i));
            }
            sol.add(min);
        }
        int ans[] = new int[sol.size()];
        for(int i=0;i<sol.size();i++){
            ans[i] = sol.get(i);
        }
        return ans;
    }
}