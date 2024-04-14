def solution2(n, lost, reserve) -> int:
    dicts = {}
    for i in range(1, n+1):
        if i in lost and i in reserve:
            dicts.setdefault(i, True)
            reserve.remove(i)
        elif i in lost :
            dicts.setdefault(i, False)
        else:
            dicts.setdefault(i, True)
            
    for i in reserve:
        if i-1 in dicts and not dicts[i-1]:
            dicts[i-1] = True 
        elif i+1 in dicts and not dicts[i+1]:
            dicts[i+1] = True
        
    return sum(1 for k, v in dicts.items() if v)

print(solution2(3, [3], [1]))

def solution(n, lost, reserve) -> int:
    dicts = {}
    for i in range(1, n+1):
        dicts.setdefault(i, False)\
            if i in set(lost) - set(reserve)\
            else dicts.setdefault(i, True)
            
    for i in set(reserve) - set(lost):
        if i-1 in dicts and not dicts[i-1]:
            dicts[i-1] = True 
        elif i+1 in dicts and not dicts[i+1]:
            dicts[i+1] = True
        
    return sum(1 for k, v in dicts.items() if v)
print(solution(3, [3], [1]))