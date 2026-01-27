from collections import deque

# 완전 탐색 (브루트 포스) 유형 O(N)
# @ Day 1
def solution(s):
    dq = deque()
    for c in s:
        if dq and dq[-1] == c:
            dq.pop()
        else: 
            dq.append(c) 
    return 0 if dq else 1

# @Day 2
def solution(s):
    dq = deque()
    current = 0
    while current < len(s):
        if dq and dq[-1] == s[current]:
            dq.pop()
            current += 1
            continue
        dq.append(s[current])
        current += 1
    return 1 if len(dq) == 0 else 0



# @Day 3


from collections import deque
def solution(s):
    dq = deque()
    for c in s:
        if dq and c == dq[-1]:
            dq.pop()
        else:
            dq.append(c)
        if not dq or dq[-1] != c:
            dq.append(c)
        else:
            dq.pop()
    return 1 if len(dq) == 0 else 0







print(solution('baabaa'))
print(solution('cdcd'))