from collections import deque
import sys

input = sys.stdin.read
data = input().splitlines()
stack = deque()
command = {
  "push": lambda n: stack.append(n),
  "top": lambda: stack[-1] if stack else -1,
  "pop": lambda: stack.pop() if stack else -1,
  "size": lambda: len(stack),
  "empty": lambda: 0 if stack else 1
}

for d in data[1:]:
    c = d.split()[0]
    if c == 'push':
        command[c](d.split()[1])
        continue
    print(command[c]())
    