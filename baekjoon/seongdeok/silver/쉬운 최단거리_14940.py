import sys
from collections import deque

input = sys.stdin.read
data = input().splitlines()
_map = data[1:]
N, M = map(int, data[0].split())

map_list = list(list(map(int, n.split())) for n in _map)
start = [0, 0]
for i, row in enumerate(map_list):
    if 2 not in row:
        continue
    for j, col in enumerate(row):
        if col == 2:
            start = [i, j]
            map_list[i][j] = 0
            break

x, y = [1, -1, 0, 0], [0, 0, 1, -1]
position_deque = deque([start])
memo_set = set([tuple(start)])

def shortest_distance_bfs():
    while(position_deque):
        map_y, map_x = position_deque.popleft() 
        for i in range(len(x)):
            move_x, move_y = map_x + x[i], map_y + y[i]
            if -1 < move_y < N and -1 < move_x < M and map_list[move_y][move_x] != 0 and (move_y, move_x) not in memo_set:
                position_deque.append([move_y, move_x])
                memo_set.add((move_y, move_x))
                map_list[move_y][move_x] = map_list[map_y][map_x] + 1
    return map_list

for row in shortest_distance_bfs():
    print(' '.join(map(str, row)))
    
    

import sys
from collections import deque

input = sys.stdin.read
data = input().splitlines()
_map = data[1:]
N, M = map(int, data[0].split())

map_list = [list(map(int, n.split())) for n in _map]
start = [0, 0]

# 시작 좌표 찾기
for i, row in enumerate(map_list):
    if 2 not in row:
        continue
    for j, col in enumerate(row):
        if col == 2:
            start = [i, j]
            map_list[i][j] = 0  # 시작점은 0으로 처리
            break

# 상하좌우 방향
x, y = [1, -1, 0, 0], [0, 0, 1, -1]

# BFS 수행을 위한 deque와 visited set
position_deque = deque([start])
memo_set = set([tuple(start)])

def shortest_distance_bfs():
    while position_deque:
        map_y, map_x = position_deque.popleft()
        for i in range(4):
            move_x, move_y = map_x + x[i], map_y + y[i]
            # 범위 확인 및 조건 검사
            if 0 <= move_y < N and 0 <= move_x < M and map_list[move_y][move_x] != 0 and (move_y, move_x) not in memo_set:
                position_deque.append([move_y, move_x])
                map_list[move_y][move_x] = map_list[map_y][map_x] + 1  # 거리 계산
                memo_set.add((move_y, move_x))  # 방문 기록
    return map_list

# BFS 결과 출력
for row in shortest_distance_bfs():
    print(' '.join(map(str, row)))
