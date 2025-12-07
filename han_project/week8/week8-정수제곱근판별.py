import math
def solution(n: int) -> int:
    if pow(math.isqrt(n),2) == n:
        return pow(math.isqrt(n)+1, 2)
    return -1

print(solution(121))