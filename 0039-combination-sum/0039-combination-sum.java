class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(candidates,target,0,new ArrayList<>(),ans);
        return ans;
    }
    private void helper(int[] arr,int remain,int st,List curr,List<List<Integer>> ans){
        if(remain==0){
            ans.add(new ArrayList<>(curr));
        }
        if(remain<0){
            return;
        }
        for(int i=st;i<arr.length;i++){
            curr.add(arr[i]);
            helper(arr,remain-arr[i],i,curr,ans);
            curr.remove(curr.size()-1);
        }
    }
}