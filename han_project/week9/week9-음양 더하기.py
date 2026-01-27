def solution(absolutes, signs):
    index, answer = 0, 0
    for i in absolutes:
        answer += i if (signs[index]) else 0 - i
        index += 1  
    return answer