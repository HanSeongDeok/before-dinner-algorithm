import sys
input = sys.stdin.read
data = input().splitlines()

for d in data:
    if d == '0':
        break
    d_value = divmod(len(d), 2)[0]
    d_mod = divmod(len(d), 2)[1]
    if d_mod:
        print("yes" if d[:d_value] == d[:d_value:-1] else "no")
    else:
        print("yes" if d[:d_value] == d[:d_value-1:-1] else "no")