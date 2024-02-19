import math as m

N, M = map(int, input().split())

for i in range(N, M+1):
    if i == 1: 
        continue
    for j in range(2, int(m.sqrt(i)) + 1):
        if i % j == 0: 
            break
    else :
        print(i)