
def solution(k, dungeons):
    from itertools import permutations
    max_cnt = 0
    n = len(dungeons)
    for order in permutations(dungeons, n):
        fatigue = k
        cnt = 0
        for min_fatigue, use_fatigue in order:
            if fatigue >= min_fatigue:
                fatigue -= use_fatigue
                cnt += 1
            else:
                break
        if cnt > max_cnt:
            max_cnt = cnt
    return max_cnt

# itertools.permutations를 사용하지 않고 직접 순열을 생성하여 문제를 푸는 코드입니다.
def solution_no_itertools(k, dungeons):
    max_cnt = 0
    n = len(dungeons)
    used = [False] * n

    def dfs(fatigue, cnt):
        nonlocal max_cnt
        if cnt > max_cnt:
            max_cnt = cnt
        for i in range(n):
            if not used[i] and fatigue >= dungeons[i][0]:
                used[i] = True
                dfs(fatigue - dungeons[i][1], cnt + 1)
                used[i] = False

    dfs(k, 0)
    return max_cnt

# 이 문제는 dfs(깊이 우선 탐색)로 모든 순서를 탐색하는 "순열" 유형입니다.
def solution(k, dungeons):
    max_cnt = 0
    memo = [0] * len(dungeons)

    def dfs(k, cnt):
        nonlocal max_cnt
        if cnt > max_cnt:
            max_cnt = cnt
        for i in range(len(dungeons)):
            if not memo[i] and k >= dungeons[i][0]:
                memo[i] = 1
                dfs(k - dungeons[i][1], cnt + 1)
                memo[i] = 0
    dfs(k, 0)
    return max_cnt

# 예시 테스트
print(solution_no_itertools(80, [[80,20],[50,40],[30,10]]))  # 3


# @Day 1
def solution(k, dungeons):
    result = []
    memo = [0] * len(dungeons)
    def dfs(temp, cnt):
        if temp:
            result.append(temp[:])
        for i in range(len(dungeons)):
            if not memo[i] and cnt >= dungeons[i][0]:
                memo[i] = 1
                temp.append(dungeons[i])
                dfs(temp, cnt - dungeons[i][1])
                temp.pop()
                memo[i] = 0
    dfs([], k)
    result = sorted(result, key=lambda x: len(x), reverse=True)
    return len(result[0])

print(solution(80, [[80,20],[50,40],[30,10]]))  # 8
print(solution(80, [[80,20],[50,40],[30,10]]))  # 15



# Combination
# idx를 이용해 현재 위치 이후의 던전만 탐색 (조합)
def custom_combination(k, dungeons):
    result = []
    def dfs(path, idx):
        result.append(path[:])
        for i in range(idx, len(dungeons)):
            path.append(dungeons[i])
            dfs(path, i + 1)
            path.pop()
    dfs([], 0)
    return len(result)

# Permutation 
# depth를 이용해 항상 다음 깊이의 던전을 추가 (순열)
def custom_permutation(k, dungeons):
    result = []
    memo = [0] * len(dungeons)
    def dfs(path):
        if path:
            result.append(path[:])
        for i in range(len(dungeons)):
            if not memo[i]:
                memo[i] = 1   
                path.append(dungeons[i])
                dfs(path)
                path.pop()
                memo[i] = 0
    dfs([])
    return len(result)

# 차이점:
# solution1은 idx를 증가시키며 i+1을 넘기므로, 중복 없이 조합을 모두 탐색합니다.
# 예를 들어 [A,B,C]라면 [A,B], [A,C], [B,C] 등 조합이 모두 나옵니다.
# solution2는 depth를 단순히 1씩 증가시키며, 항상 depth 위치의 던전만 추가하므로
# [A,B], [B,C] 등 연속된 부분집합(슬라이딩 윈도우)만 탐색합니다.
# 즉, solution1은 조합, solution2는 연속 부분집합(슬라이스)만 탐색합니다.

# 예시 테스트
print(custom_combination(80, [[80,20],[50,40],[30,10]]))  # 8
print(custom_permutation(80, [[80,20],[50,40],[30,10]]))  # 15
