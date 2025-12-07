def solution(s):
    answer = ''
    for i in s.split(' '):
        for j in range(len(i)):
            answer += i[j].upper()\
                    if j % 2 == 0\
                    else i[j].lower()
        answer += ' '
    return answer.strip()

print(solution("try hello world"))