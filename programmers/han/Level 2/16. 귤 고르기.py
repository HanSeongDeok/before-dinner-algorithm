def solution(k, tangerine):
    answer = 0
    tangerine = sorted(tangerine)
    
    dupl_map = {}
    for i in tangerine:
        if i not in dupl_map:
            dupl_map[i] = 1
        else :
            dupl_map[i] += 1
    
    dupls = sorted(dupl_map.values(), reverse=True)
    cnt = 0
    for v in dupls:
        if cnt >= k:
            break
        cnt += v
        answer += 1
    return answer

print(solution(6, [1,3,2,5,4,5,2,3]))