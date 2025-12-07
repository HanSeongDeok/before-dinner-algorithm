import math
def solution(brown, yellow):
    start = int(math.sqrt(brown + yellow))
    for i in range(start, 5000):
        v, r = divmod(brown + yellow, i)
        if r == 0 and (v - 2) * (i - 2) == yellow:               # 직사각형 조건 만족을 생각 못함... 멍청이...
            return [max(v, i), min(v, i)]
    return -1


print(solution(10, 2))