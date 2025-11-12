from collections import deque
def solution(n):
    if n == 1:
        return 1 
    if n == 2:
        return 2
    fibo = deque([1, 2])
    for i in range(2, n):
        fibo.append((fibo[i-2] + fibo[i-1]) % 1000000007)
    return fibo[-1]

print(solution(5))