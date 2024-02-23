class Solution(object):
    def isSubsequence(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        i = 0
        s_length = len(s)
        if s_length == 0:
            return True
        for char in t:
            if char == s[i]:
                i += 1
            if i == s_length:
                break
        return i == s_length
        
