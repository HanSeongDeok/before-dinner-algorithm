# 27. 피로도 문제 -> KEYWORD: 순열 (permute) 
def solution(k, dungeons):
    permute = custom_permute([], [], dungeons[:])
    result, count = 0, 0
    for p in permute:
        compare_value = k
        count = 0
        for fatigue, consum in p:
            if compare_value < fatigue:
                break
            compare_value -= consum
            count += 1
        result = max(count, result)
    return result

def custom_permute(permute_array, current_array, dungeons_copy):
    if not dungeons_copy:
        permute_array.append(current_array[:])
        return 
    
    for index in range(len(dungeons_copy)):
        current_array.append(dungeons_copy[index])
        custom_permute(permute_array, current_array, dungeons_copy[:index] + dungeons_copy[index+1:])
        current_array.pop()
    return permute_array

print(solution(80, [[80,20],[50,40],[30,10]]))

# 25. 의상 문제 -> KEYWORD: 경우의 수 (Number of Case)
# CASE 1 모든 경우의 수를 직접 구하는 로직으로 풀어보자
def solution_test(clothes):
    clothes_permute = custom_permute(0, clothes, [], [])
    return clothes_permute

def custom_permute(index, clothes, current_array, permute_array):
    if index == len(clothes):
        permute_array.append(current_array[:])
        return

    custom_permute(index+1, clothes, current_array, permute_array)
    current_array.append(clothes[index])
    custom_permute(index+1, clothes, current_array, permute_array)
    current_array.pop()
    return permute_array

print(solution_test([["yellow_hat", "headgear"], 
                    ["blue_sunglasses", "eyewear"], 
                    ["green_turban", "headgear"]]))

# CASE 2 경우의 수의 값을 구하여 풀어보자 (공집합이 포함될 수 있음을 유념하자) 
def solution(clothes):
    clothes_map= {}
    for i, catagory in clothes:
        clothes_map[catagory] = clothes_map[catagory] + 1\
            if catagory in clothes_map.keys()\
            else 1 
    
    result = 1
    for i in clothes_map.values():
        result *= (i + 1)
    return result - 1