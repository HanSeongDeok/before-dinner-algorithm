import sys
input = sys.stdin.read
data = input().splitlines()
N,M = data[0], data[1]

network_list = []
for i in sorted(data[2:]):
    numbers = i.split() 
    isNew = True
    for j in network_list:
        if numbers[0] in j or numbers[1] in j:
            j.update(numbers)
            isNew = False
            break
    if(isNew):
        network_list.append(set(numbers))    

result = set()
for network in network_list:
    if '1' in network:
        result.update(network)

print(len(result)-1)
 