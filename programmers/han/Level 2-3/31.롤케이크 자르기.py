from collections import Counter

# @Day 1
# 그리디/슬라이딩 윈도우 유형 문제제
def solution(topping):
    result = 0
    topping_cntr = Counter(topping)
    save_set = set()
    for k in topping:
        save_set.add(k)
        topping_cntr[k] -= 1
        if topping_cntr[k] == 0:
            del topping_cntr[k]
        if len(save_set) == len(topping_cntr):
            result += 1
    return result


from collections import Counter
def solution(topping):
    topping_cntr = Counter(topping)
    compare_set = set()
    result = 0
    for t in topping:
        compare_set.add(t)
        topping_cntr[t] -= 1
        if topping_cntr[t] == 0:
            del topping_cntr[t]
        if len(compare_set) == len(topping_cntr):
            result += 1
    return result

# Test cases
print(solution([1,2,1,3,1,4,1,2]))  # 2
print(solution([1,2,3,1,4]))  # 0
