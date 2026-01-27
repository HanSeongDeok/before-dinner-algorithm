def solution(msg):
    answer = []
    asciis = [chr(i) for i in range(65, 91)]
    # ord == ascii 변환 함수 ordianl position의 약자 
    mani_index = 0
    for i in range(len(msg)):
        if (mani_index != 0):
            mani_index -= 1
            continue
        cnt = 0
        while(i + cnt < len(msg)):
            cnt += 1
            if (msg[i:i+cnt+1] in asciis):
                if (i == len(msg)-1 or i + cnt == len(msg)):
                    answer.append(asciis.index(msg[i:i+cnt+1])+1)        
                    break
                continue
            answer.append(asciis.index(msg[i:i+cnt])+1)
            asciis.append(msg[i:i+cnt+1]) 
            break
        mani_index = cnt - 1
    return answer

print(solution("KAKAO"))
print(solution("TOBEORNOTTOBEORTOBEORNOT"))