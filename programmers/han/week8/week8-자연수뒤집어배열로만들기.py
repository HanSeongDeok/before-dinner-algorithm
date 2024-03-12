def solution(n: int) -> int:
    return [int(i) for i in list(reversed(str(n)))]

print(solution(12345))