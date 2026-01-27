def solution(k, m, score):
    if len(score) < m:
        return 0
    score = sorted(score, reverse=True)
    cnt = 0
    for i in range(0, len(score), m):
        if(i+m > len(score)):
            break
        cnt += min(score[i:i+m]) * m
    return cnt

print(solution(	3, 4, [1, 2, 3, 1, 2, 3, 1]))