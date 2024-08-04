# 오답노트
# 
def solution(park, routes):
    park_dict = {}
    NSWE_dict = {'N': [-1, 0], 'S': [1, 0], 'W': [0, -1], 'E': [0, 1]}
    sp = []
    for i, v in enumerate(park):
        temp = []
        for index, c in enumerate(v):
            if c == 'S':
                c = 'O'
                sp.append(i)
                sp.append(index)
            temp.append(c)
        park_dict[i] = temp
    
    for i in routes:
        order = NSWE_dict[i.split(' ')[0]] 
        order = [j * int(i.split(' ')[1]) for j in order]
        
        if sp[0] + order[0] >= len(park_dict) or sp[0] + order[0] < 0:
            continue
        
        if sp[1] + order[1] >= len(park_dict[0]) or sp[1] + order[1] < 0:
            continue
        
        # order[1]/ order[0]이 음수일 경우 reverse로 탐색해야 함을 간과.
        if order[0] == 0:
            isValid = True 
            step_range = range(sp[1], sp[1] + order[1] + 1)\
                if order[1] > 0\
                else range(sp[1], sp[1] + order[1] - 1, -1)
            for n in step_range:
                if (park_dict[sp[0]][n] == 'X'):
                    isValid = False 
                    break
            if (isValid):
                sp[1] += order[1]
        
        elif order[1] == 0:
            isValid = True
            step_range = range(sp[0], sp[0] + order[0] + 1)\
                if order[0] > 0\
                else range(sp[0], sp[0] + order[0] - 1, -1)
            for n in step_range:
                if (park_dict[n][sp[1]] == 'X'):
                    isValid = False 
                    break
            if (isValid):
                sp[0] += order[0]
    return sp

print(solution(["OSO","OOO","OXO","OOO"], ["E 2","S 3","W 1"]))