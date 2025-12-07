def solution(n: int) -> str:
    return "수박" * int(n/2)\
           if divmod(n, 2)[1] == 0\
           else "수박" * int(n/2) + "수"