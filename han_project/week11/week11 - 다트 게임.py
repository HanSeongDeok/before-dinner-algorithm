def solution(dartResult):
    answer = []
    cnt = 0
    for i in range(len(dartResult)):
        if (i+1 != len(dartResult) and dartResult[i:i+2] == '10'):
            answer.append(10)
            cnt += 1
            i += 2
        if (dartResult[i] == "S") : continue
        elif (dartResult[i] == "D") : answer[cnt-1] = pow(answer[cnt-1], 2)
        elif (dartResult[i] == "T") : answer[cnt-1] = pow(answer[cnt-1], 3)
        elif (dartResult[i] == "*") :
            answer[cnt-1] = answer[cnt-1] * 2
            if(cnt-2 != -1) :
                 answer[cnt-2] = answer[cnt-2] * 2
        elif (dartResult[i] == "#") :
            answer[cnt-1] = answer[cnt-1] * -1
        else : 
            answer.append(int(dartResult[i]))
            cnt += 1 

    return sum(answer)

print(solution("1D2S#10S"))