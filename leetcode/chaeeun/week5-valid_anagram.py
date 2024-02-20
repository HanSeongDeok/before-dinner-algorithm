class Solution(object):
    def isAnagram(self, s, t):
        letterMap = {}
        for letter in s:
            if letter in letterMap:
                letterMap[letter] += 1
            else:
                letterMap[letter] = 1

        for letter in t:
            if letter in letterMap:
                letterMap[letter] -= 1
            else:
                return False
        for letterCount in letterMap.values():
            if letterCount != 0:
                return False
        return True
