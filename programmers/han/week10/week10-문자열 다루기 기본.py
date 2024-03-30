def solution(s: str) -> bool:
    try:
        int(s)
    except:
        return False
    return True\
        if(len(s) == 4 or len(s) == 6)\
        else False 
    

print(solution("00000000"))