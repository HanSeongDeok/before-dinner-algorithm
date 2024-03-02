import math
def solution(n) -> int:
    divisions = []
    for i in range(1, int(math.sqrt(n))+1):
        if math.remainder(n, i) == 0:
            divisions.append(i)
            divisions.append(divmod(n,i)[0])
    
    return sum(divisions)

def solution2(n) -> int:
    return sum([i \
            for i in range(1, n+1) \
            if math.remainder(n,i) == 0])
    
print(solution2(12))