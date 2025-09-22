# @Day 1
def solution(s):
    answer = []
    for i in s.split(' '):
        if(i[:1].isdigit()):
            answer.append(i[:1] + i[1:].lower())   
        else :
            answer.append(i[:1].upper() + i[1:].lower())
    return ' '.join(answer)
