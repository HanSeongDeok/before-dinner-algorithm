import sys
input = sys.stdin.read
data = input().splitlines()

for d in data[:-1]:
    abc = sorted(map(int, d.split()))
    c = abc.pop()
    print("right") if pow(c, 2) == pow(abc[0], 2) + pow(abc[1], 2) else print("wrong")

