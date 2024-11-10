import math
def solution(progresses, speeds):
    answer = []
    date_list = []
    for p, s in zip(progresses, speeds):
        progress = 100 - p
        date = math.ceil(progress / s) 
        date_list.append(date)

    s_p, e_p = 0, 0
    cnt = 0
    while(e_p < len(date_list)):
        if date_list[s_p] >= date_list[e_p]:
           e_p += 1
           cnt += 1
           continue
        s_p = e_p
        answer.append(cnt)
        cnt = 0
    answer.append(cnt)
    return answer

print(solution([93, 30, 55], [1, 30, 5]))
print(solution([95, 90, 99, 99, 80, 99], [1, 1, 1, 1, 1, 1]))