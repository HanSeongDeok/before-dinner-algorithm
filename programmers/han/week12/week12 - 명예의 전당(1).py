def solution(k, score):
    temp = []
    result = []
    for i in range(len(score)):
        if(i >= k and min(temp) < score[i]):
            temp.remove(min(temp))
            temp.append(score[i])
        elif(i < k) :
            temp.append(score[i])
        result.append(min(temp))    
    return result

print(solution(3, [10, 100, 20, 150, 1, 100, 200]))