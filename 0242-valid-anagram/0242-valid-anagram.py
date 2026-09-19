class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        seen = {}
        for ch in s:
            seen[ch] = seen.get(ch, 0) + 1
        for ch in t:
            seen[ch] = seen.get(ch, 0) - 1
            if seen[ch] < 0:
                return False
        return True
