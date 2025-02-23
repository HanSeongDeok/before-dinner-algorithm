import sys
input = sys.stdin.read
data = input().splitlines()
index = data[0]
member_list = sorted(data[1:], key= lambda m: int(m.split()[0]))
[print(m) for m in member_list]
