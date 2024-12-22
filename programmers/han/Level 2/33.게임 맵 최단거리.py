# 오답 
def solution(maps):
    answer = -1
    def map_dfs(row, col, value, map_set):
        nonlocal answer
        if row == len(maps) or col == len(maps[0]) or row < 0 or col < 0:
            return 
        
        if  maps[row][col] == 0 or [row, col] in map_set:
            return 

        if row == len(maps)-1 and col == len(maps[0])-1:
            answer = value
            return
    
        map_set.append([row, col])
        map_dfs(row + 1, col, value + maps[row][col], map_set)
        map_dfs(row, col + 1, value + maps[row][col], map_set)
        map_dfs(row - 1, col, value + maps[row][col], map_set)

    map_dfs(0,0,1,[])
    return answer

# Assert 11
print(solution([[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]))


# 해답 -> 천재인걸!!!
# 아 이거 leetcode에서도 봤고 전에도 한번 풀어봤는데 바로 틀렸음
# 외웁시다 이런 최소 경로 찾는 문제는 상하좌우 객체 만들어서 BFS로 풀이!!
from collections import deque

def solution(maps):
    directions = [(1, 0), (0, 1), (-1, 0), (0, -1)]
    rows, cols = len(maps), len(maps[0])

    queue = deque([(0, 0, 1)])  # (row, col, distance)
    visited = set()
    visited.add((0, 0))

    while queue:
        row, col, dist = queue.popleft()

        if row == rows - 1 and col == cols - 1:
            return dist

        for dr, dc in directions:
            nr, nc = row + dr, col + dc

            if 0 <= nr < rows and 0 <= nc < cols and maps[nr][nc] == 1 and (nr, nc) not in visited:
                visited.add((nr, nc)) 
                queue.append((nr, nc, dist + 1)) 

    return -1  
 
from collections import deque
def solution(maps):
    direction = {
        "DOWN": (1,0), "UP": (-1,0), "RIGHT": (0,1), "LEFT": (0,-1)
    }
    map_set = set([(0,0)])
    maps_bfs = deque([(0,0,1)])
    
    while(maps_bfs):
        row, col, value = maps_bfs.popleft()
        if row == len(maps) -1 and col == len(maps[0])-1:
            return value
            
        for r, c in direction.values():
            if row + r >= len(maps) or col + c >= len(maps[0]) or col + c < 0 or row + r < 0 or (row + r, col + c) in map_set:
                continue
            if  maps[row + r][col + c] > 0:
                map_set.add((row + r, col + c))
                maps_bfs.append((row + r, col + c, value + 1))
    return -1

# Assert 11
print(solution([[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]))
print(solution([[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,0],[0,0,0,0,1]]))

