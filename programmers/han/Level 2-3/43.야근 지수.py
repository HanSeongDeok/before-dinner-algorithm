
import heapq

def solution(works, n):
    # 최대 힙을 사용하므로 음수로 바꿔줌
    works = [-w for w in works]
    heapq.heapify(works)
    for _ in range(n):
        if not works or works[0] == 0:
            break
        max_work = heapq.heappop(works)
        heapq.heappush(works, max_work + 1)  # max_work는 음수, 1 더하면 실제로 1 깎임
    return sum(w ** 2 for w in works)





import heapq as hq
from math import pow
def solution(works, n):
    works = [-w for w in works]
    hq.heapify(works)

    for _ in range(n):
        w = hq.heappop(works)
        if not w:
            break 
        hq.heappush(works, w + 1) 

    return sum(int(pow(w, 2)) for w in works)

print(solution([4,3,3], 4))  # 12
print(solution([2,1,2], 1))  # 6
print(solution([1,1], 3))    # 0


# DFS로 모든 경우의 수를 탐색할 수 있는데, 각 작업별로 하나씩 깎는 선택지를 n번 동안 모두 조합해야 함.
# 하지만 works의 길이와 n이 커질수록 경우의 수가 기하급수적으로 늘어나기 때문에
# 시간복잡도가 O((len(works)) ** n)으로 실질적으로 풀 수 없음.

# 예시 코드 (비효율적, small-case만 가능)
def dfs(works, n):
    if n == 0 or all(w == 0 for w in works):
        return sum(w**2 for w in works)
    min_value = 1000000
    for i in range(len(works)):
        if works[i] == 0:
            continue
        works[i] -= 1
        temp = dfs(works, n-1)
        min_value = min(min_value, temp)
        works[i] += 1
    return min_value

# 작은 케이스에서는 가능
print(dfs([4,3,3], 4))  # 12
