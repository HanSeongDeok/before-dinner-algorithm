import sys
from collections import deque

input = sys.stdin.read
number = int(input())
number_list = deque([n for n in range(1, number+1)])

while len(number_list) > 1:
    number_list.popleft()
    number_list.append(number_list.popleft())
    
print(number_list[0])