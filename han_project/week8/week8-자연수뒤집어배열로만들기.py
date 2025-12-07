def solution(n: int) -> int:
    return [int(i) for i in reversed(str(n))]

print(solution(12345))