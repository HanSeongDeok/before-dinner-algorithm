
# @Day 1
# 이 함수의 시간복잡도는 O(N)입니다. 
# 각 인덱스는 최대 한 번씩 stack에 들어가고 한 번씩 stack에서 pop 되기 때문입니다.
from inspect import stack


def solution(numbers):
    result = [-1] * len(numbers)
    stack = []
    for i, num in enumerate(numbers):
        while stack and numbers[stack[-1]] < num:
            idx = stack.pop()
            result[idx] = num
        stack.append(i)
    return result



# def solution(numbers):
#     n = len(numbers)
#     answer = [-1] * n
#     for i in range(n):
#         for j in range(i+1, n):
#             if numbers[j] > numbers[i]:
#                 answer[i] = numbers[j]
#                 break
#     return answer

# 와 이런건 어떻게 생각하냐 도대체...
def solution(numbers):
    result = [-1] * len(numbers)
    stack = []
    for i, num in enumerate(numbers):
        while stack and numbers[stack[-1]] < num:
            result[stack.pop()] = num
        stack.append(i)
    return result    




#@Day2
from collections import deque
def solution(arr): 
    result = [-1] * len(arr)
    dq = deque()
    for i, v in enumerate(arr):
        while dq and arr[dq[-1]] < v:
            idx = dq.pop()
            result[idx] = v
        dq.append(i)
#@Day 2
def solution(numbers):
    result = [-1] * len(numbers)
    stack = []
    for i, n in enumerate(numbers):
        while stack and numbers[stack[-1]] < n:
            result[stack.pop()] = n 
        stack.append(i)
    return result


# 예시 테스트
print(solution([2, 3, 3, 5]))   # [3, 5, 5, -1]
print(solution([9, 1, 5, 3, 6, 2])) # [-1, 5, 6, 6, -1, -1]
