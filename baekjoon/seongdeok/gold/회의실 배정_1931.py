import sys
from collections import deque

input = sys.stdin.read
data = input().splitlines()
length, data = int(data[0]), data[1:]
meeting_schedule = deque()

data = list(list(map(int, d.split())) for d in data)
data = sorted(data, key=lambda k: (k[1], k[0]))

now_end = 0
count = 0
for start, end in data:
    if start >= now_end:
        count += 1
        now_end = end
        
print(count)

## DFS 시간 초과 많은 시간 복잡도가 소요되기에 Greedy 기법으로 타파 가능
def meeting_room_dfs(times, index):
    if index == length:
        meeting_schedule.append(times[:])
        return
    
    for i in range(index, length):
        start, end = map(int, data[i].split())
        if times and times[-1][1] >= start:
            if i == length-1:
                meeting_room_dfs(times, i + 1)        
            continue
        times.append([start, end])
        meeting_room_dfs(times, i + 1)
        times.pop()
        
meeting_room_dfs([], 0)
print(max(len(t) for t in meeting_schedule))