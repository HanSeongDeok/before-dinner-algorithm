def solution(d, budget):
    answer = 0
    d.sort()
    for department in d:
        if(department <= budget):
            budget -= department
            answer += 1
        else:
            break
    return answer
