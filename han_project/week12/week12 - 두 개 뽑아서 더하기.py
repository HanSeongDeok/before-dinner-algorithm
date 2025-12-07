from itertools import combinations as C
 
def solution(numbers):
    return sorted(set(combination_custom(numbers, 2)))

def combination_custom(numbers, c):
    arr = []
    def combination(temp_arr, start):
        if len(temp_arr) == c:
            arr.append(sum(temp_arr))
            return
        
        for i in range(start, len(numbers)):
            temp_arr.append(numbers[i])
            combination(temp_arr, i+1)
            temp_arr.pop()
    
    combination([], 0)
    return arr

def solution2(numbers):
    return sorted(set(i + j for i, j in C(numbers, 2)))

print(solution2([2,1,3,4,1]))