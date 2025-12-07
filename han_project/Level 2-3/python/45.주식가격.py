
def solution(prices):
    n = len(prices)
    answer = [0] * n
    stack = []
    for i in range(n):
        while stack and prices[stack[-1]] > prices[i]:
            idx = stack.pop()
            answer[idx] = i - idx
        stack.append(i)
    while stack:
        idx = stack.pop()
        answer[idx] = n - 1 - idx
    return answer






def solution(prices):
    result = [0] * len(prices)
    memo = []
    for i in range(len(prices)):
        while memo and prices[memo[-1]] > prices[i]:
            idx = memo.pop()
            result[idx] = i - idx
        memo.append(i)
    for idx in memo:
        result[idx] = len(prices) - idx -1
    return result

    


print(solution([1, 2, 3, 2, 3]))