import math
def solution(num) -> str:
    return "Even" \
        if math.remainder(num, 2) == 0 \
        else "Odd" 
        
print(solution(3))