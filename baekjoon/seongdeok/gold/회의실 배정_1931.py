import sys
from collections import deque

input = sys.stdin.read
data = input().splitlines()
length, data = int(data[0]), data[1:]
meeting_schedule = deque()

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