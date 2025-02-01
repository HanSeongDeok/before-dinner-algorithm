import collections
def solution_wrong(numbers):
    answer = []
    numbers_deq = collections.deque(numbers)
    for _ in range(0, len(numbers)):
        a = numbers_deq.popleft()
        if (not numbers_deq or a >= max(numbers_deq)):
            answer.append(-1)
            continue
        cnt = 0
        while cnt < len(numbers_deq):
            if(a < numbers_deq[cnt]):
                answer.append(numbers_deq[cnt])
                break
            cnt += 1
    return answer

# 다시 풀어보기
def solution(numbers):
    n = len(numbers)
    answer = [-1] * n 
    stack = []  

    for i in range(n):
        while stack and numbers[stack[-1]] < numbers[i]:
            answer[stack.pop()] = numbers[i]
        stack.append(i)
    
    return answer


print(solution([2,3,3,5]))
print(solution([9,1,5,3,6,2]))