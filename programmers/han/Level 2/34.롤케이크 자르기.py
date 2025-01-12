# 오답 -> 성능 X
def solution_1(topping):
    answer = 0
    for point in range(1, len(topping)+2):
        if len(set(topping[:point])) == len(set(topping[point:])):
            answer += 1
    return answer

# RETRY -> 위의 코드에서 set() 메서드 비교를 딕셔너리로로 직접 구현
def solution(topping):
    answer = 0
    topping_dupl_prefix = {topping[0] : 1}
    topping_dupl_suffix = {}
    for i in range(1, len(topping)):
        if topping[i] in topping_dupl_suffix:
            topping_dupl_suffix[topping[i]] += 1
            continue
        topping_dupl_suffix[topping[i]] = 1
        
    for point in range(1, len(topping)):
        t = topping[point]
        topping_dupl_prefix[t] = 1\
            if t not in topping_dupl_prefix\
            else topping_dupl_prefix[t] + 1
    
        if topping_dupl_suffix[t] - 1 == 0:
            del topping_dupl_suffix[t]
        else: 
            topping_dupl_suffix[t] -= 1
        
        if len(topping_dupl_prefix) == len(topping_dupl_suffix):
            answer += 1
    return answer

print(solution([1, 2, 1, 3, 1, 4, 1, 2]))
print(solution([1, 2, 3, 1, 4]))