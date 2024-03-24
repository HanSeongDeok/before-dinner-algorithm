def solution(numbers: list) -> int:
    answer = [i for i in range(0, 10)]
    return sum([i for i in answer if i not in numbers])