# @Day 1
from shlex import join
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


# @Day 3
def solution (s):
    convert_s = []
    for w in s.split(' '):
        if w[:1].isdigit():
            convert_s.append(w[:1] + w[1:].lower())
        else:
            convert_s.append(w[:1].upper() + w[1:].lower())
    return ' '.join(convert_s)





def solution(s):
    words = s.split(' ')
    result = []
    for w in words:
        if not w:
            result.append(w)
            continue
        if w and w[:1].isdigit():
            result.append(w.lower())
        else:
            result.append(w[:1].upper() + w[1:].lower())
    return ' '.join(result)


def solution(s):
    return ' '.join(w.capitalize() if w else '' for w in s.split(' '))


print(solution("3people unFollowed me"))
print(solution("for the last  week"))