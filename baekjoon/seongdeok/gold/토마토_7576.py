import sys
from collections import deque

input = sys.stdin.read
data = input().splitlines()
M, N = map(int,data[0].split())
tomato_box = [list(map(int, d.split())) for d in data[1:]]        

queue = deque()
for i in range(N):
    for j in range(M):
        if tomato_box[i][j] == 1:
            queue.append((j, i))

x = [1, -1, 0, 0]
y = [0, 0, 1, -1]

def tomato_bfs():
    while queue:
        tomato_x, tomato_y = queue.popleft()
        
        for i in range(4):
            move_x, move_y = tomato_x + x[i], tomato_y + y[i]
            
            if 0 <= move_x < M and 0 <= move_y < N and tomato_box[move_y][move_x] == 0:
                tomato_box[move_y][move_x] = tomato_box[tomato_y][tomato_x] + 1
                queue.append((move_x, move_y))
    return tomato_box

tomato_box = tomato_bfs()
final_day = max(max(day) for day in tomato_box)
for box in tomato_box:
    if 0 in box:
        final_day = 0
        break

print(final_day - 1)