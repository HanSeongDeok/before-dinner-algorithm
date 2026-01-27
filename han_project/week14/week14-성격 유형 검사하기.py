def solution(survey, choices):
    Indication_dict = {
        "RT": 0,
        "CF": 0,
        "JM": 0,
        "AN": 0,
        "TR": 0,
        "FC": 0,
        "MJ": 0,
        "NA": 0
    }
    
    for s, c in zip(survey, choices):
        Indication_dict[s] += 4-c
    
    answer = ''
    cnt = 0
    for i in Indication_dict:
        if cnt >= 4: 
            break
        if Indication_dict[i] >= Indication_dict[i[::-1]]: 
            answer += i[:1]
        else:
            answer += i[1:2]
        cnt += 1
    return answer

print(solution(["TR", "RT", "TR"], [7, 1, 3]))