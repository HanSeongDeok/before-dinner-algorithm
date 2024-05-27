def solution(k, score):
    answer = []
    hall = []
    for i in score:
        if len(hall)<k:
            hall.append(i)
        else:
            if min(hall)<i:
                hall.remove(min(hall))
                hall.append(i)
        answer.append(min(hall))
    return answer
