def solution(n, arr1, arr2):
    return [bin(pow(2, n) | i | j)[3:].translate(str.maketrans({"0" : " ", "1" : "#"}))
            for i, j in zip(arr1, arr2)]

print(solution(5, [9, 20, 28, 18, 11], [30, 1, 21, 17, 28]))