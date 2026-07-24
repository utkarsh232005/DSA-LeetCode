class Solution {
    public int uniqueXorTriplets(int[] nums) {
        Set<Integer> uniqSet = new HashSet<>();
        for(int i : nums){
            uniqSet.add(i);
        }
        Integer[] uniqNums = uniqSet.toArray(new Integer[0]);
        int n = uniqNums.length;
        Set<Integer> pairXor = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                pairXor.add(uniqNums[i] ^ uniqNums[j]);
            }
        }
        Set<Integer> tripletXor = new HashSet<>();
        for(int pair : pairXor){
            for(int i : uniqNums){
                tripletXor.add(pair ^ i);
            }
        }
        return tripletXor.size();
    }
}