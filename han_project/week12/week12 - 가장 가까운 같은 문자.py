def solution(s):
    dict = {}
    answer = []
    cnt = 1
    for i in s:
        if i in dict.keys():
            answer.append(cnt - dict[i])
            dict[i] = cnt
        else:
            answer.append(-1)
            dict[i] = cnt
        cnt += 1
    return answer
    
def solution2(s):
    dict = {}
    answer = []
    for i, v in enumerate(s):
        if v in dict.keys():
            answer.append((i+1) - dict[v])
        else:
            answer.append(-1)
        dict[v] = i+1 
    return answer
    
print(solution2("foobar"))