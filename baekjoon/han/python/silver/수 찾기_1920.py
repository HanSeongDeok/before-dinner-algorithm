import sys
input = sys.stdin.read
data = input().splitlines()

A = set(map(int, data[1].split()))
M = list(map(int, data[3].split()))

p1, p2 = 0, len(M)-1

while(p1 <= p2):
    M[p1] = 1 if M[p1] in A else 0
    M[p2] = 1 if M[p2] in A else 0
    
    p1 += 1
    p2 -= 1

print("\n".join(map(str, M)))