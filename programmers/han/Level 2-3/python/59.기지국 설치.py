def solution(n, stations, w):
    answer = 0
    coverage = 2 * w + 1
    prev = 0
    for s in stations:
        left = s - w
        dist = max(0, left - prev - 1)
        if dist > 0:
            answer += (dist + coverage - 1) // coverage
        prev = s + w
    dist = n - prev
    if dist > 0:
        answer += (dist + coverage - 1) // coverage
    return answer


#@day 1
import math
def solution(n, stations, w):
    answer = 0
    ran = w * 2 + 1
    prev = 0
    for s in stations:
        distance = s - w - prev - 1
        if distance > 0:
            answer += math.ceil(distance / ran)
        prev = s + w
    if n - prev > 0:
        answer += math.ceil((n - prev) / ran)
    return answer

# print(solution(11, [4, 7], 1))
print(solution(16, [9], 2))