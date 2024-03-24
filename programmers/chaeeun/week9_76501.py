def solution(absolutes, signs):
    length = len(absolutes)
    answer = 0
    for i in range(length):
        answer += absolutes[i] if signs[i] > 0 else absolutes[i] * -1
    return answer
