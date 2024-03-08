import math
def solution(n) -> int:      
    return [i for i in range(2, n) if math.remainder(n-1, i) == 0][0]


def solution2(n) -> int:
    result = 0
    for i in range(2, n):
        if math.remainder(n-1, i) == 0:
          result = i
          break
    return result


print(solution(12))
print(solution2(12))