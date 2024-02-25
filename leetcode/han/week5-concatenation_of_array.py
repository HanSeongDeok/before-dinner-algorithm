from typing import List

class Solution:
    def getConcatenation(self, nums: List[int]) -> List[int]:
        results = []
        for i in range(len(nums)*2):
            if i == 0: 
                results.append(nums[0])
            else: results.append(nums[i % len(nums)])
        return results

list = [1, 2, 1]
print(Solution().getConcatenation(list))