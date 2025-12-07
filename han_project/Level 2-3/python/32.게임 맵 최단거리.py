from collections import deque
from turtle import distance

# 이 문제는 "BFS(너비 우선 탐색)"을 이용한 최단 거리(Shortest Path) 유형 문제입니다.
def solution(maps):
    n = len(maps)
    m = len(maps[0])

    # 상, 하, 좌, 우
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    visited = [[False] * m for _ in range(n)]
    queue = deque()
    queue.append((0, 0, 1))  # (x좌표, y좌표, 현재까지 거리)
    visited[0][0] = True

    while queue:
        x, y, dist = queue.popleft()
        if x == n - 1 and y == m - 1:
            return dist
        for dir in range(4):
            nx = x + dx[dir]
            ny = y + dy[dir]
            if 0 <= nx < n and 0 <= ny < m and maps[nx][ny] == 1 and not visited[nx][ny]:
                visited[nx][ny] = True
                queue.append((nx, ny, dist + 1))
    return -1


# @Day 1
def solution(maps):
    xl = len(maps[0])
    yl = len(maps)

    xy_dict = {
        "x": [0, 0, 1, -1],
        "y": [1, -1, 0, 0] 
    }

    visited = [[0] * xl for _ in range(yl)]
    visited[0][0] = 1
    map_dq = deque([[0, 0, 1]])

    while map_dq:
        x, y, distance = map_dq.popleft()
        if xl - 1 == x and yl - 1 == y:
            return distance
        for i in range(4):
            next_x = xy_dict["x"][i] + x
            next_y = xy_dict["y"][i] + y
            if 0 <= next_x < xl and 0 <= next_y < yl and maps[next_y][next_x]\
                    and not visited[next_y][next_x] :
                visited[next_y][next_x] = 1
                map_dq.append([next_x, next_y, distance + 1])
    return -1

def solution(maps):
    yl = len(maps)
    xl = len(maps[0])

    visited = [[xl] * xl for i in range(yl)]
    visited[0][0] = 1

    x = [0, 0, -1, 1]
    y = [-1, 1, 0, 0]

    dq = deque([[0, 0, 1]])
    while dq:
        nx, ny, distance = dq.popleft()
        if nx + 1 == xl and ny + 1 == yl:
            return distance
        for i in range(4):
            next_y = ny + y[i]
            next_x = nx + x[i]
            if 0 <= nx + x[i] < xl and 0 <= ny + y[i] < yl\
                and not visited[next_y][next_x] and maps[next_y][next_x]:
                    dq.append([next_x, next_y, distance + 1])
                    visited[next_y][next_x] = True
    return -1




# @Day 2
## visited memo를 리스트나 큐로 활용하면 성능 fail이 발생한다.
from collections import deque
def solution(maps):
    n, m = len(maps), len(maps[0])

    x_list = [0, 0, -1, 1]
    y_list = [-1, 1, 0, 0]

    visited = [[0] * m for _ in range(n)]
    visited[0][0] = 1
    dq = deque([[1, 1, 1]])

    while dq:
        y, x, dist = dq.popleft()
        if y == n and x == m:
            return dist
        for i in range(4):
            ny = y_list[i] + y
            nx = x_list[i] + x
            if 1 <= ny <= n and 1 <= nx <= m and visited[ny-1][nx-1]:
                continue
            if 1 <= ny <= n and 1 <= nx <= m and maps[ny-1][nx-1]:
                visited[ny-1][nx-1] = 1
                dq.append([ny, nx, dist+1])
    return -1

print(solution([[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]))  # 11
print(solution([[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,0],[0,0,0,0,1]]))  # -1















# BFS FORM
from collections import deque

def bfs(graph, start):
    visited = [False] * len(graph)
    queue = deque([start])
    visited[start] = True

    while queue:
        v = queue.popleft()
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True

def bfs(graph, start):
    dq = deque([start])
    visited = [0] * len(graph)
    visited[start] = 1
    result = [start]
    while dq:
        idx = dq.popleft()
        for node in graph[idx]:
            if not visited[node]:
                visited[node] = 1
                dq.append(node)
            if node not in result:
                result.append(node)
    return result

graph = [
    [],             
    [2, 3, 8],      
    [1, 7],         
    [1, 4, 5],     
    [3, 5],         
    [3, 4],         
    [7],            
    [2, 6, 8],      
    [1, 7]          
]

print(bfs(graph, 1))  # 출력: 1 2 3 8 7 4 5 6 
