from collections import deque
from unittest import result

# @Day 1
def solution(priorities, location):
    dq = deque([[i, p] for i, p in enumerate(priorities)])
    result = 1
    while dq:
        idx, priority = dq.popleft()
        valid = True
        for i, p in dq:
            if p > priority:
                valid = False
                break
        # if any(p > priority for i, p in dq):
        #     valid = False
        if not valid:
            dq.append([idx, priority])
            continue
        if idx == location:
            return result
        result += 1
    return result 


# @Day 2
from collections import deque
def solution(priorities, location):
    dq_priorities = deque([[i, v] for i, v in enumerate(priorities)])
    result = 1
    while dq_priorities:
        idx, priority = dq_priorities.popleft()
        if any(priority < v for i, v in dq_priorities):
            dq_priorities.append([idx, priority])
            continue
        if location == idx:
            return result
        result += 1
    return result



# @ Day 3
from collections import deque
def solution(arr, n):
    result = 1
    dq = deque([i, v] for i, v in enumerate(arr))
    while dq:
        p = dq.popleft()
        # isTrue = True
        # for i in dq:
        #     if p[1] < i[1]:
        #         dq.append(p)
        #         isTrue = False
        #         break
        # if not isTrue:
        #     continue
        if any(p[1] < i[1] for i in dq):
            dq.append(p)
            continue
        if n == p[0]:
            return result
        else:
            result += 1
    return result

print(solution([2, 1, 3, 2], 2))  # 1
print(solution([1, 1, 9, 1, 1, 1], 0))  # 5



