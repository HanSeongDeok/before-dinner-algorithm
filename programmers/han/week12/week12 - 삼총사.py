from itertools import combinations
def solution(number):
    combination_three = combinations(number, 3)
    return sum(1 for arr in combination_three if sum(arr) == 0)

def combinations(arr, r):
    result = []
    
    def combines(temp, start):
        if(len(temp) == r):
            result.append(temp[:])
            return
        
        for i in range(start, len(arr)):
            temp.append(arr[i])
            combines(temp, i + 1)
            temp.pop()
    
    combines([], 0)
    return result

def solution2(number):
    return sum(1 for c in combinations(number, 3) if sum(c) == 0)

print(solution([-3, -2, -1, 0, 1, 2, 3]))
print(solution2([-3, -2, -1, 0, 1, 2, 3]))