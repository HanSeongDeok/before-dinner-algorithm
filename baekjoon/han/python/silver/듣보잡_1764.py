import sys
from collections import deque

input = sys.stdin.read
data = input().splitlines()
N, M = map(int, data[0].split())

name_set = set()
for i in range(N):
    name_set.add(data[i+1])

name_list = list()
for i in range(N, N+M):
    if data[i+1] in name_set:
        name_list.append(data[i+1])
      
print(len(sorted(name_list)))
print("\n".join(sorted(name_list)))