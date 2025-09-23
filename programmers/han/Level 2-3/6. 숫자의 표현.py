# @Day 1
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

print(solution(15))