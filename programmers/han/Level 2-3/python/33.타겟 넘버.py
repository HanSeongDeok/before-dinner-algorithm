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

# @Day 2
def solution(numbers, target):
    result = 0
    def dfs(num, idx):
        nonlocal result
        if idx == len(numbers):
            if num == target: 
                result += 1
            return

        dfs(num + numbers[idx], idx+1)
        dfs(num - numbers[idx], idx+1)
    dfs(0, 0)
    return result





def solution(arr, n):
    dq = deque()
    def dfs(temp, idx):
        if len(temp) == len(arr):
            dq.append(sum(temp[:]))
            return
        temp.append(arr[idx])
        dfs(temp, idx + 1)
        temp.pop()

        temp.append(arr[idx] * -1)
        dfs(temp, idx + 1)
        temp.pop()

    dfs([], 0)
    result = 0
    for d in dq:
        if d == n:
            result += 1
    return result



print(solution([1, 1, 1, 1, 1], 3))
print(solution([4, 1, 2, 1], 4))  # 2