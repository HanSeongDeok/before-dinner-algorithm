def solution(nums):
    half_num = len(nums) // 2
    set_num = len(set(nums))
    
    return min(half_num, set_num)

def solution2(nums):
    result = set()
    dfs_sets(nums, 0, [], result, len(nums)//2)
    max_value = 0
    for i in result:
       max_value = max(max_value, len(set(i))) 
    return max_value

def dfs_sets(pokemons, index, current, result, target_count):
    if len(current) == target_count:
        result.add(frozenset(current))
        return
    if index >= len(pokemons):
        return
    dfs_sets(pokemons, index + 1, current + [pokemons[index]], result, target_count)
    dfs_sets(pokemons, index + 1, current, result, target_count)


def dfs_combinations(pokemons, index, current, result, num):
    if len(current) == num:
        result.append(current[:])
        return
    
    if index == len(pokemons):
        return
    
    current.append(pokemons[index])
    dfs_combinations(pokemons, index+1, current, result, num)

    current.pop()
    dfs_combinations(pokemons, index+1, current, result, num)
    
print(solution([3,3,3,2,2,2]))