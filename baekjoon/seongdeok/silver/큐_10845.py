import sys
from collections import deque

input = sys.stdin.read
data = input().splitlines()
queue = deque()

queue_command = {
    "push" : lambda n: queue.append(n),
    "pop" : lambda : queue.popleft() if queue else -1,
    "size" : lambda : len(queue),
    "empty" : lambda : 0 if queue else 1,
    "front" : lambda : queue[0] if queue else -1,
    "back" : lambda : queue[-1] if queue else -1
}

for d in data[1:]:
    c = d.split()[0]
    if c == "push":
        queue_command[c](d.split()[1])
        continue
    print(queue_command[c]())
    
