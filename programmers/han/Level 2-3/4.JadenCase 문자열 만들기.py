# @Day 1
from turtle import Turtle


def solution(s):
    answer = []
    for i in s.split(' '):
        if(i[:1].isdigit()):
            answer.append(i[:1] + i[1:].lower())   
        else :
            answer.append(i[:1].upper() + i[1:].lower())
    return ' '.join(answer)


# @Day 2
def solution(s):
    result = ''
    is_first = True
    for c in s:
        if c == ' ':
            result += c
            is_first = True
        else:
            if is_first:
                result += c.upper()
            else:
                result += c.lower()
            is_first = False
    return result


print(solution("3people unFollowed me"))
print(solution("for the last week"))