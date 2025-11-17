from collections import deque

index = int(input())
sign_list = list(input() for _ in range(index))

for sign in sign_list:
    d = deque()
    for c in sign: 
        if d and d[-1] == '(' and c == ')':
            d.pop()
        else:
            d.append(c)
    print(f"{'NO' if d else 'YES'}")