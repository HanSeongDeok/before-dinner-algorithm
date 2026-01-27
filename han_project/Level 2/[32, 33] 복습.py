# 32. 타겟 넘버
def solution(numbers, target):
    answer = 0
    def numbers_dfs(index, value):
        nonlocal answer
        if index == len(numbers):
            if target == value:
                answer += 1
            return
        numbers_dfs(index + 1, value + numbers[index])
        numbers_dfs(index + 1, value - numbers[index])
    numbers_dfs(0, 0)
    return answer

print(solution([1, 1, 1, 1, 1], 3))

# 33. 게임 맵 최단거리
from collections import deque
def solution(maps):
    answer = -1
    direction = [(1,0),(-1,0),(0,1),(0,-1)]
    def maps_bfs(map_set, map_deque):
        nonlocal answer, direction
        while(map_deque):
            row, col, value = map_deque.popleft()
            if row == len(maps)-1 and col == len(maps[0])-1:
                answer = value
                break
            for r, c in direction:
                if row + r == len(maps) or col + c == len(maps[0]) or row + r < 0 or col + c < 0 or (row + r, col + c) in map_set:
                    continue
                if maps[row + r][col + c] > 0:
                    map_set.add((row + r, col + c))
                    map_deque.append((row + r, col + c, value + 1))
    maps_bfs(set([(0,0)]), deque([(0, 0, 1)]))
    return answer
    
print(solution([[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]))