class Solution {
    public int majorityElement(int[] nums) {
        // int ans =0;
        // HashMap<Integer,Integer> hm = new HashMap<>();
        // for(int i =0;i<nums.length;i++){
        //     hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        // }
        // Set<Integer> keySet = hm.keySet();
        // for(Integer key : keySet){
        //     if(hm.get(key) > nums.length/2){
        //         ans = key;
        //     }
        // }
        // return ans;

        // for(int i=0;i<nums.length;i++){
        //     int cnt =0;
        //     for(int j=0;j<nums.length;j++){
        //         if(nums[i] == nums[j]){
        //             cnt++;
        //         }
        //     }
        //     if(cnt > nums.length/2)return nums[i];
        // }
        // return -1;
        int cnt = 0;
        int el=0;
        for (int i = 0; i < nums.length; i++) {
            if (cnt == 0) {
                cnt = 1;
                el = nums[i];
            } else if (nums[i] == el) {
                cnt++;
            } else {
                cnt--;
            }
        }
        int cnt1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == el) {
                cnt1++;
            }
        }
        if (cnt1 > nums.length / 2) {
            return el;
        }
        return -1;
    }
}
