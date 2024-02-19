from typing import List

class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        sets = set()
        for i in range(len(nums)):
            if nums[i] in sets:
                return True
            sets.add(nums[i])
        return False
    