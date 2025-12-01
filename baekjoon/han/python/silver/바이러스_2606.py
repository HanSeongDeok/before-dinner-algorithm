from collections import deque
import sys

input = sys.stdin.read
data = input().splitlines()
N,M = data[0], data[1]
computers = data[2:]

bfs_deque = deque(['1'])
computer_set = set(['1'])

while bfs_deque:
    computer = bfs_deque.popleft()
    
    for connection in computers:
        start, end = connection.split()
        
        if computer == start and end not in computer_set:
            computer_set.add(end)
            bfs_deque.append(end)
        elif computer == end and start not in computer_set:
            computer_set.add(start)
            bfs_deque.append(start)
            
print(len(computer_set)-1)

# network_list = []
# for i in sorted(data[2:]):
#     numbers = i.split() 
#     isNew = True
#     for j in network_list:
#         if numbers[0] in j or numbers[1] in j:
#             j.update(numbers)
#             isNew = False
#             break
#     if(isNew):
#         network_list.append(set(numbers))    

# result = set()
# for network in network_list:
#     if '1' in network:
#         result.update(network)

# print(len(result)-1)
