from collections import deque

class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        arr = [char for char in s]
        queue = deque(arr)
        
        for i in range(len(t)):
            if queue != 0 and queue[0] == t[i]: queue.popleft()
            if len(queue) == 0: break
    
        return len(queue) == 0

str1 = "abc"
str2 = "ahbgdc"
print(Solution().isSubsequence(str1, str2))    

str1 = "axc"
str2 = "ahbgdc" 
print(Solution().isSubsequence(str1, str2))    