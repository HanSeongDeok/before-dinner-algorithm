def solution(s):
    x, non_x, answer = 0, 0, 1
    start = s[0]
    sum = 0
    for i in range(len(s)-1):
        if s[i] == start:
            x += 1
        else:
            non_x += 1
        if x == non_x:
            answer += 1
            start = s[sum + x + non_x]
            sum += x + non_x
            x = non_x = 0
    return answer

print(solution("abracadabra"))
