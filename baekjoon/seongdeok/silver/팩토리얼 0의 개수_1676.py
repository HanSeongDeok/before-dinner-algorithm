import sys
input = sys.stdin.read
number = int(input())

def n_factorial(n):
    if number == 0:
        return 0
    if n == 1:
        return 1
    return n * n_factorial(n-1)
cnt = 0
for c in str(n_factorial(number))[::-1]:
    if number == 0:
        break 
    if c == '0':
        cnt += 1
        continue
    break
    
print(cnt)