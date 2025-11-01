from collections import deque
def solution(x, y, n):
    visited = set()
    queue = deque()
    queue.append((x, 0))
    visited.add(x)

    while queue:
        num, cnt = queue.popleft()
        if num == y:
            return cnt
        for next_num in (num + n, num * 2, num * 3):
            if next_num <= y and next_num not in visited:
                visited.add(next_num)
                queue.append((next_num, cnt + 1))
    return -1



# @Day 1
from collections import deque
def solution(x, y, n):
    visited = set([x])
    dq = deque([[x, 0]])
    
    while dq:
        num, result = dq.popleft()
        if num == y:
            return result
        for next_n in (num + n, num * 2, num * 3):
            if next_n <= y and next_n not in visited:
                visited.add(next_n)
                dq.append([next_n, result + 1])
    return -1

print(solution(10, 40, 5))    # 2
print(solution(10, 40, 30))   # 1
print(solution(2, 5, 4))      # -1