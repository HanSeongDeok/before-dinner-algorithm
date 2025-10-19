# @Day 1
from unittest import result


def solution(n, computers):
    visited = [False] * n
    
    def dfs(v):
        visited[v] = True
        for i in range(n):
            if computers[v][i] == 1 and not visited[i]:
                dfs(i)
    
    answer = 0
    for i in range(n):
        if not visited[i]:
            dfs(i)
            answer += 1
    return answer


# @Day 1
def solution(n, computers):
    visited = [0] * n
    result = 0
    def dfs(idx):
        visited[idx] = 1
        for i in range(n):
            if computers[idx][i] and not visited[i]:
                dfs(i)
    for i in range(n):
        if not visited[i]:
            dfs(i)
            result += 1
    return result



# 또 다른 풀이 방식 -> BFS 방식의 풀이
def solution_bfs(n, computers):
    from collections import deque
    visited = [False] * n
    answer = 0
    for i in range(n):
        if not visited[i]:
            queue = deque([i])
            visited[i] = True
            while queue:
                v = queue.popleft()
                for j in range(n):
                    if computers[v][j] == 1 and not visited[j]:
                        visited[j] = True
                        queue.append(j)
            answer += 1
    return answer


# 예시 테스트
print(solution(3, [[1,1,0],[1,1,0],[0,0,1]])) # 2
print(solution(3, [[1,1,0],[1,1,1],[0,1,1]])) # 1
