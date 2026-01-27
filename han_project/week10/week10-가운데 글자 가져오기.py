def solution(s: str) -> str:
    div, mod = divmod(len(s),2)
    return s[div-1:div+1]\
           if mod == 0\
           else s[div]

print(solution("abcdef"))