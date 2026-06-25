class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String,Integer> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;
        for(int i=0;i<list1.length;i++){
            map.put(list1[i],i);
        }
        for(int i=0;i<list2.length;i++){
            if(map.containsKey(list2[i])){
                int sum = map.get(list2[i])+i;
                if(sum<minSum){
                    minSum = sum;
                    list.clear();
                    list.add(list2[i]);
                }else if(sum == minSum){
                    list.add(list2[i]);
                }
            }
        }
        String[] ans = new String[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}