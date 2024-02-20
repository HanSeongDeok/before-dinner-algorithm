class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        sets = set(s)
        sett = set(t)
        return sorted(sets) == sorted(sett)
         