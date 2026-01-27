import itertools as iter
import math
def solution(nums: int):
    # result = dfs_prime_combination(nums, 0, [], result, 3)
    result = iter.combinations(nums, 3)
    cnt = 0
    for i in result:
        check = True
        for j in range(2, int(math.sqrt(sum(i)))+1):
            if divmod(sum(i), j)[1] == 0:
                check = False   
                break
        if(check):
            cnt += 1
    return cnt

def dfs_prime_combination(nums, i, current, result, limit):
    if (len(current) == limit):
        result.append(current[:])
        return result
    
    if (i == len(nums)):
        return result
    
    current.append(nums[i])
    result = dfs_prime_combination(nums, i+1, current, result ,limit)
    
    current.pop()
    result = dfs_prime_combination(nums, i+1, current, result ,limit)
    
    return result

print(solution([1,2,7,6,4]))