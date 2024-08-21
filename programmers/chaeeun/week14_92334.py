def solution(id_list, report, k):
    user_num = len(id_list)
    answer = [0] * user_num
    user_report = [[] for _ in range(user_num)]
    reported_num = [0] * user_num
    stopped = []
    
    id_index = {id_list[i]: i for i in range(user_num)}
    
    for rep in report:
        reporter, reported = rep.split()
        reporter_index = id_index[reporter]
        reported_index = id_index[reported]
        
        if reported not in user_report[reporter_index]:
            user_report[reporter_index].append(reported)
            reported_num[reported_index] += 1
            if reported_num[reported_index] >= k and reported not in stopped:
                stopped.append(reported)
    
    for i in range(user_num):
        for reported in user_report[i]:
            if reported in stopped:
                answer[i] += 1
                
    return answer
