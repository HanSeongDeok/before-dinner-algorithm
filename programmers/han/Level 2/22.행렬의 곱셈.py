def solution(arr1, arr2):
    answer = []
    for a1 in arr1:
        row_arr = [0] * len(arr2[0])
        for i, a in enumerate(a1):
            for j, b in enumerate(arr2[i]):
               row_arr[j] += a * b
        answer.append(row_arr)
    return answer

print(solution([[2, 3, 2], [4, 2, 4], [3, 1, 4]],[[5, 4, 3], [2, 4, 1], [3, 1, 1]]))