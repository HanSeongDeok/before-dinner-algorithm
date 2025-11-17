import sys
input = sys.stdin.read
data = list(map(int, input().splitlines()[1:]))

def fibonacci(n):
    global memo
    if n in memo:
        return memo[n]
    elif n == 0:
        memo[0] = [1, 0]
        return [1, 0]
    elif n == 1:
        memo[1] = [0, 1] 
        return [0, 1]
    else:
        one = fibonacci(n-1)
        two = fibonacci(n-2)
        memo[n] = [one[0] + two[0], one[1] + two[1]] 
        return memo[n]
    
for n in data:
    memo = dict()
    count = fibonacci(n)
    print(f'{count[0]} {count[1]}')
    
