import math
def solution(sizes):
    r, c = 0, 0    
    for i, j in sizes:
        if max(i, j) > r:
            r = max(i, j)
        if min(i, j) > c:
            c = min(i, j)
    return r * c