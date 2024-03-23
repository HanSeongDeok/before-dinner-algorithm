def solution(arr):
    min_num = min(arr)
    answer = [i for i in arr if i != min_num ]
    if not answer:
        return [-1]
    return answer
