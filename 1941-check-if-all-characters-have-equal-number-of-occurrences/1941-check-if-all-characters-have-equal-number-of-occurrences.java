// class Solution {
//     public boolean areOccurrencesEqual(String s) {
//         HashMap<Character, Integer> map = new HashMap<>();
//         for (int i = 0; i < s.length(); i++) {
//             char ch = s.charAt(i);
//             map.put(ch, map.getOrDefault(ch, 0) + 1);
//         }
//         int curr = map.get(s.charAt(0));
//         for (int i = 1; i < s.length(); i++) {
//             char ch = s.charAt(i);
//             if (map.get(ch) != curr) {
//                 return false;
//             } else {
//                 curr = map.get(ch);
//             }
//         }
//         return true;
//     }
// }

//short approach HashMap + HashSet 

class Solution{
    public boolean areOccurrencesEqual(String s){
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        HashSet<Integer> set = new HashSet<>(map.values());
        return set.size() == 1;
    }
}