class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        String nums = "123456789";
        for(int i=2;i<=9;i++){
            for(int j=0;j<=9-i;j++){
                int num = Integer.parseInt(nums.substring(j, j + i));
                if(num > high){
                    break;
                }else if(num >=low && num <=high){
                    ans.add(num);
                }
            }
        }
        return ans;
    }
}