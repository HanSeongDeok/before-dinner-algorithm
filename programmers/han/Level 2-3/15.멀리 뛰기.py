# @ Day 1
def solution(n):
    n_1, n_2 = 1, 2
    result = 0
    if n == n_1:
        return 1
    if n == n_2:
        return 2
    for i in range(3, n+1):
        result = n_1 + n_2
        n_1, n_2 = n_2, result
    return result % 1234567

print(solution(4))
print(solution(3))