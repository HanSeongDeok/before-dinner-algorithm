from collections import deque
# @Day 1
def solution(numbers, target):
    dq = deque()
    def dfs(idx, temp):
        if idx == len(numbers): 
            dq.append(temp[:])
            return

        temp.append(numbers[idx])
        dfs(idx+1, temp)
        temp.pop()

        temp.append(-numbers[idx])
        dfs(idx+1, temp)
        temp.pop()
    dfs(0, [])
    result = 0
    
    result = sum(1 for q in dq if sum(q) == target)
    return result

print(solution([1, 1, 1, 1, 1], 3))
        