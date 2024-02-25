from typing import List 

class Solution:
    def replaceElements(self, arr: List[int]) -> List[int]:
        value = -1
        for i in range(len(arr)-1, -1, -1): 
            temp = arr[i]
            arr[i] = value
            value = max(value, temp)
        return arr
        
list = [17,18,5,4,6,1]
print(Solution().replaceElements(list)) 