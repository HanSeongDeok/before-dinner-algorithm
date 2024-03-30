def solution(arr1: list, arr2: list) -> list:
    return [sum_arr(a, b) for a, b in zip(arr1, arr2)]

def sum_arr(arr1: list, arr2: list) -> list:
    return [a + b for a, b in zip(arr1, arr2)]

print(solution([[1,2],[2,3]], [[3,4],[5,6]]))