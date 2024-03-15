import math
def solution(n):
    num = math.sqrt(n)
    return (num + 1) ** 2 if num % 1 == 0 else -1
