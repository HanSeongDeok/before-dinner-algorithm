def solution(arr, divisor):
    answer = [element for element in arr if element % divisor == 0]
    if not answer:
        return [-1]
    return sorted(answer)
