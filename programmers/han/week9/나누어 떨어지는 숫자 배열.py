def solution(arr: list, divisor: int):
    answer = [i for i in arr if divmod(i, divisor)[1] == 0]
    if len(answer) == 0: return [-1]
    return sorted(answer)