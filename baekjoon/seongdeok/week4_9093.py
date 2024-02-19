cnt = int(input())

for i in range(cnt):
    VPS = list(input())
    sum = 0
    valid = True
    for j in range(len(VPS)):
        if sum == 0 and VPS[j] == ")": 
            valid = False    
            break
        if VPS[j] == '(':
            sum += 1
        else:
            sum -= 1
    if sum == 0 and valid: print("YES")
    else: print("NO")
        