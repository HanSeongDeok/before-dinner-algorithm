def solution(clothes):
    noc = []
    category_map, clothes_map = {}, {}
    for item, category in clothes:
        clothes_map[item] = category
        if category in category_map:
            category_map[category] += 1
        else:
            category_map[category] = 1
    
    def number_of_case(index, current):
        if index == len(clothes_map):
            noc.append(list(current)[:])
            return
        
        number_of_case(index+1, current)
        
        current.append(clothes_map[clothes[index][0]])
        number_of_case(index+1, current)
        current.pop()
        
    number_of_case(0, [])
    cnt = 1
    for i in noc:
        if len(i) != len(set(i)):
            cnt += 1   
    return len(noc) - cnt


def solution2(clothes):
    clothes_map = {}
    for item, category in clothes:
        clothes_map[category] = clothes_map[category] + 1 if category in clothes_map else 1
    
    answer = 1
    for i in clothes_map.values():
        answer *= (i + 1) 
    return answer - 1
    
solution2([["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]])

