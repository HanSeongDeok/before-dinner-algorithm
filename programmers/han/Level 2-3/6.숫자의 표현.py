# @ Day 1
# 완전 탐색 기법  브루트포스
def solution(n):
    answer = 0
    for i in range(1, n + 1):
        start = 0
        current = i
        while start < n:
            start += current
            current += 1
        if start == n:
            answer += 1
    return answer

# @ Day2
def solution(n):
    same_count = 0
    for i in range(1, n + 1):
        current = i
        cnt = 0
        while cnt < n:
            cnt += current 
            current += 1
        if cnt == n:
            same_count += 1
    return same_count

# Day 3
def solution(n):
    answer = 0
    for i in range(1, n + 1):
        cnt = 0
        current = i
        while cnt < n:
            cnt += current
            current += 1
        if cnt == n:
            answer += 1
    return answer

print(solution(15))
print(solution(5))