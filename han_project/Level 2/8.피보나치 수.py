def solution(n):
    first, second = 1, 1
    for i in range(2, n+1):
       if i == n:      
           return second % 1234567
       first, second = second, first
       second += first
    return second % 1234567
      
print(solution(11))