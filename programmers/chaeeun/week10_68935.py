def solution(n):
    answer = 0
    s_answer = ""
    while n > 0:
        s_answer += str(n % 3)
        n //= 3

    return int(s_answer, 3)
