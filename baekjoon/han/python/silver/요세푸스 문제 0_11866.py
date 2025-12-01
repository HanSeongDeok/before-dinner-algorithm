import sys
from collections import deque

input = sys.stdin.read
N, K = map(int, input().split())
number_deque = deque([n for n in range(1, N + 1)])

sequence = []
index = 0
while(number_deque):
    index += 1
    pop_number = number_deque.popleft()
    if index == K:
        sequence.append(pop_number)
        index = 0
        continue
    number_deque.append(pop_number)

print("<" + ", ".join(map(str, sequence)) + ">")