import sys
from collections import deque

input = sys.stdin.read
data = input().splitlines()
_map = data[1:]
N, M = map(int, data[0].split())

map_list = list(list(map(int, n.split())) for n in _map)
start = [0, 0]
for i, row in enumerate(map_list):
    for j, col in enumerate(row):
        if col == 2:
            start = [i, j]
            map_list[i][j] = 0
        elif col == 1:
            map_list[i][j] = -1

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
                map_list[move_y][move_x] = abs(map_list[map_y][map_x]) + 1
    return map_list

for row in shortest_distance_bfs():
    print(' '.join(map(str, row)))
