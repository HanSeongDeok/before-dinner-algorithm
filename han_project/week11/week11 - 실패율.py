def solution2(N, stages):
    stage_dict = {i: 0 for i in range(1, N+1)}
    for i in stages:
        if i in stage_dict:
            stage_dict[i] += 1
        
    fail_dict = {}
    for i in stage_dict:
        if i-1 not in stage_dict:
            fail_dict[i] = stage_dict[i] / len(stages)     
            continue
        count = sum(stage_dict[j] 
                    for j in range(i)  
                    if j in stage_dict.keys())
        fail_dict[i] = stage_dict[i] / (len(stages) - count)
        
    fail_dict = sorted(fail_dict.items(), key=lambda item: item[1], reverse=True)
    return [key for key, value in fail_dict]

print(solution2(4, [4, 4, 4, 4, 4]))

def solution(N, stages):
    stage_dict = {i: 0 for i in range(1, N+1)}
    for i in stages:
        if i in stage_dict:
            stage_dict[i] += 1
        
    fail_dict = {}
    total = len(stages)
    for i in stage_dict:
        if total <= 0:
            fail_dict[i] = 0
            continue    
        fail_dict[i] = stage_dict[i] / total
        total -= stage_dict[i]
        
    fail_dict = sorted(fail_dict.items(), key=lambda item: item[1], reverse=True)
    return [key for key, value in fail_dict]
