# 오답 -> 공백도 문자로 인정된다. 문제를 잘 확인 할 수 있도록!
def solution2(s):
    answer = ''
    number = ['0','1','2','3','4','5','6','7','8','9']
    for i in s.split(' '):
        if(i == ''):
            continue
        if i[0] in number:
            answer += " " + i[0] + i[1:].lower()
        else:
            i = i[:1].upper() + i[1:].lower() 
            answer += " " + i 
    return answer.strip()

def solution(s):
    answer = []
    number = ['0','1','2','3','4','5','6','7','8','9']
    for i in s.split(' '):
        if i[:1] in number:
            answer.append(i[0] + i[1:].lower())
        else:
            i = i[:1].upper() + i[1:].lower() 
            answer.append(i) 
    return ' '.join(answer)

print(solution("  3people  unfollowed  me  "))