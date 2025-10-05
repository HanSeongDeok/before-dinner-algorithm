
# @Day 1 
# 2차원 행렬 유형  
import enum


def solution(arr1, arr2):
    answer = []
    for a1 in arr1:
        temp = [0] * len(arr2[0]) 
        for i, a in enumerate(a1):
            for j, b in enumerate(arr2[i]):
                temp[j] += a * b
        answer.append(temp)
    return answer
                




def solution(arr1, arr2):
    answer = []
    for a1 in arr1:
        temp = [0] * len(arr2[0])
        for i, a in enumerate(a1):
            for j, b in enumerate(arr2[i]):
                temp[j] += a * b
        answer.append(temp)
    return answer





print(solution([[1, 4], [3, 2], [4, 1]], [[3, 3], [3, 3]]))
print(solution([[2, 3, 2], [4, 2, 4], [3, 1, 4]], [[5, 4, 3], [2, 4, 1], [3, 1, 1]]))


