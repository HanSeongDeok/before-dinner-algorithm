import math
# 완전 탐색(브루트 포스) 유형
#@ Day 1
def solution (brown, yellow):
    number = brown + yellow
    height = int(math.sqrt(brown + yellow))
    for h in range(height, 0 , -1):
        weight, remainder = divmod(number, h)
        if remainder == 0 and (weight - 2) * (h - 2) == yellow:
            return [weight, h]
    return []
     

#@ Day 2
def solution(brown, yellow):
    total = brown + yellow
    height = int(math.sqrt(total))
    for h in range(height, 0, -1):
        w, r = divmod(total, h)
        if r == 0 and (w - 2) * (h - 2) == yellow:
            return [w, h]
    return []








from math import sqrt
def solution(brown, yellow):
    width = brown + yellow
    start_height = int(sqrt(width))
    for h in range(start_height, 0, -1):
        length = width // h
        if length * h == width and (length - 2) * (h - 2) == yellow:
            return [length, h]
    return []
        







# @ Day 3
def solution(brown, yellow):
    start_h = int((brown + yellow) ** 0.5)

    for h in range(start_h, 0, -1):
        w, remainder = divmod(brown + yellow, h)
        if not remainder and (w-2) * (h-2) == yellow:
            return [w, h] 
    return []
    


print(solution(10, 2))   # [4, 3]
print(solution(8, 1))    # [3, 3]
print(solution(24, 24))  # [8, 6]
print(solution(14, 4))   # [8, 6]
