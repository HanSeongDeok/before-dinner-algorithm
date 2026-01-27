def solution(n: int) -> int:
    result = [int(i) for i in list(str(n))]
    return sum(result)
    
print(solution(987))