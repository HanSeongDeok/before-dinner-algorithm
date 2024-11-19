def solution(priorities, location):
    answer = 0
    index_list = [0] * len(priorities)
    index_list[location] = 1 
    while(priorities):
        max_value = max(priorities)
        i = index_list.pop(0)
        p = priorities.pop(0)
        if max_value > p:
            priorities.append(p)
            index_list.append(i)
        else:
            answer += 1
            if i != 0:
                break
    return answer

print(solution([2, 1, 3, 2], 2))
print(solution([1, 1, 9, 1, 1, 1], 0))