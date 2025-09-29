from collections import Counter


# 탐욕적 기법 유형
# @ Day 1
def solution(k, tangerine):
    box = Counter(tangerine)
    box = sorted(box.values(), reverse=True)
    
    count = 0
    result = 0

    for b in box:
        if count >= k:
            break
        count += b
        result += 1
    return result

def solution(k, tangerine):
    answer = 0
    dupl_map = {}
    for i in tangerine:
        if i in dupl_map:
            dupl_map[i] += 1
        else:
            dupl_map[i] = 1
    
    dupl_list = sorted(dupl_map.values(), reverse=True)
    
    cnt = 0
    for i in dupl_list:
        if cnt >= k:
            break
        cnt += i
        answer += 1
    return answer

print(solution(6, [1, 3, 2, 5, 4, 5, 2, 3])) 
print(solution(4, [1, 3, 2, 5, 4, 5, 2, 3]))
print(solution(2, [1, 1, 1, 1, 2, 2, 2, 3]))
