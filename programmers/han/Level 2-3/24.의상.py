from collections import defaultdict
def solution(clothes):
    clothes_dict = defaultdict(int)
    combi_n = 1
    for _, sort in clothes:
        clothes_dict[sort] += 1

    for c in clothes_dict.values():
        combi_n *= (c + 1)
    
    return combi_n - 1

# 조합 알고리즘 구현 (n개 중 r개를 뽑는 경우의 수)
def custom_combination(arr, r):
    result = []
    def dfs(path, idx):
        if len(path) == r:
            result.append(path)
            return
        for i in range(idx, len(arr)):
            dfs(path + [arr[i]], i + 1)
    dfs([], 0)
    return result

custom_combination([1,2,3,4],2)

# 예시 테스트
print(solution([["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]))  # 5
print(solution([["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]]))  # 3
