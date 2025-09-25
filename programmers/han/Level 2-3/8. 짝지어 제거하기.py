from collections import deque

# 완전 탐색 유형 O(N)
# @ Day 1
def solution(s):
    dq = deque()
    for c in s:
        if dq and dq[-1] == c:
            dq.pop()
        else: 
            dq.append(c) 
    return 0 if dq else 1

print(solution('baabaa'))
print(solution('cdcd'))