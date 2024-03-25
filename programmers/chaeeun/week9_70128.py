def solution(a, b):
    length = len(a)
    answer = 0
    for i in range(length):
        answer += a[i] * b[i]
    return answer
