class Solution {
    public int longestSubstring(String s, int k) {
        int max = 0;
        for (int targetUnique = 1; targetUnique <= 26; targetUnique++) {
            HashMap<Character, Integer> map = new HashMap<>();
            int l = 0, r = 0;
            while (r < s.length()) {
                map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
                while (map.size() > targetUnique) {
                    char leftChar = s.charAt(l);
                    map.put(leftChar, map.get(leftChar) - 1);
                    if (map.get(leftChar) == 0) {
                        map.remove(leftChar);
                    }
                    l++;
                }
                if (map.size() == targetUnique && isValid(map, k)) {
                    max = Math.max(max, r - l + 1);
                }
                r++;
            }
        }

        return max;
    }
    private boolean isValid(HashMap<Character, Integer> map, int k) {
        for (int count : map.values()) {
            if (count < k) return false;
        }
        return true;
    }
}