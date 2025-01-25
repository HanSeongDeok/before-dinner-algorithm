def solution(msg):
    answer = []
    asciis = [chr(i) for i in range(65, 91)]
    mani_index = 0
    for i in range(len(msg)):
        if (mani_index != 0):
            mani_index -= 1
            continue
        cnt = 0
        while(i + cnt < len(msg)):
            cnt += 1
            if (msg[i:i+cnt] in asciis):
                if (i+cnt == len(msg)-1):
                    answer.append(asciis.index(msg[i:i+cnt])+1)        
                    break
                continue
            answer.append(asciis.index(msg[i:i+cnt-1])+1)
            asciis.append(msg[i:i+cnt]) 
            break
        mani_index = cnt - 2
    return answer

#print(solution("KAKAO"))
print(solution("TOBEORNOTTOBEORTOBEORNOT"))