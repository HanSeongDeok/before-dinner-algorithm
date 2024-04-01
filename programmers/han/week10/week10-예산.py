def solution(d, budget):
    sum, cnt = 0, 0
    for i in sorted(d):
        sum += i
        if sum > budget:
            break
        cnt += 1
    return cnt