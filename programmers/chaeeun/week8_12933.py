def solution(n: int) -> int:
    new = list(str(n))
    new.sort(reverse=True)
    return int("".join(new))
