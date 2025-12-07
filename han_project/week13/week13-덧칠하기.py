def solution(n, m, section):
    result = 0
    memo = [False] * (n + 1)
    for i in section:
        start = i
        if not memo[start]:
           for i in range(start, min(start + m - 1, n)+1):
               memo[i] = True
           result += 1        
    return result

print(solution(8,4,[2,3,6]))