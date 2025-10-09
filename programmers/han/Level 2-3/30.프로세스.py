from collections import deque

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

print(solution([2, 1, 3, 2], 2))  # 1
print(solution([1, 1, 9, 1, 1, 1], 0))  # 5



