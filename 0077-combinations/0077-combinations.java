class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), 1, n, k);
        return ans;
    }
    private void backtrack(List<List<Integer>> ans,List<Integer> curr,int st,int n,int k){
        if (curr.size() == k) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=st;i<=n;i++){
            curr.add(i);
            backtrack(ans,curr,i+1,n,k);
            curr.remove(curr.size()-1);
        }
    }
}