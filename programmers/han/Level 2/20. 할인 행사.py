def solution(want, number, discount):
    answer = 0
    discount_map = dict(zip(want, number))
    total_days = sum(number)
    if total_days > len(discount):
        return 0
    
    for i in range(len(discount) - total_days, sum(number) + len(discount) - total_days):
        if discount[i] in discount_map:
            discount_map[discount[i]] -= 1 
    
    if list(discount_map.values()) == [0] * len(want):
        answer += 1

    for i in range(len(discount) - total_days):
        discount_map = dict(zip(want, number))
        for j in range(i, i + sum(number)):
            if discount[j] in discount_map:    
                discount_map[discount[j]] -= 1
        if list(discount_map.values()) == [0] * len(want):
                answer += 1
    return answer

def solution2(want, number, discount):
    answer = 0
    total_days = sum(number)
    
    if total_days > len(discount):
        return 0

    for i in range(len(discount) - total_days + 1):
        discount_map = dict(zip(want, number))
        for j in range(i, i + total_days):
            if discount[j] in discount_map:
                discount_map[discount[j]] -= 1
        
        if all(value == 0 for value in discount_map.values()):
            answer += 1

    return answer

print(solution(["banana", "apple", "rice", "pork", "pot"], 
               [3, 2, 2, 2, 1], 
               ["chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"]))