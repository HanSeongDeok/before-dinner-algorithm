def solution(a: list, b: list) -> int:
    return sum([l * w for l, w in zip(a, b)])