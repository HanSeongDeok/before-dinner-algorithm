import sys
input = sys.stdin.read
data = input().splitlines()
index = int(data[0])
[print(n) for n in sorted(data[1:], key=lambda n: (int(n.split()[0]), int(n.split()[1])))]
