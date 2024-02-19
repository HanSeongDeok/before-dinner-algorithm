class Solution(object):
    def containsDuplicate(self, nums):
        dictionary = {}
        for i in nums :
            if i in dictionary:
                return True
            else:
                dictionary[i] = 1
        return False
