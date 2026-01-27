# @ Day 1
# 동적 프로그래밍(Dynamic Programming, DP) 유형
def solution(n):
    number_F = 0
    F1 = 1
    F2 = 1
    for i in range(2, n):
        number_F = F1 + F2
        F1, F2 = F2, number_F
        if i + 1 == n:
            return number_F % 1234567 

def solution(n):
    first, second = 1, 1
    for i in range(2, n+1):
       if i == n:      
           return second % 1234567
       first, second = second, first + second
    return second % 1234567


# @ Day 2
def solution(n):
    result = 1
    first, second = 1, 1
    for i in range (2, n):
        result = first + second
        first, second = second, result
    return result % 1234567


def solution(n):
    f, s = 1, 1
    fibo = 1
    for _ in range(3, n+1):
        fibo = f + s
        f, s = s, fibo 
    return fibo % 1234567






def solution(n):
    first, second = 1, 1
    fibo_nubmer = 1
    for i in range(2, n):
        fibo_nubmer = first + second
        first, second = second, fibo_nubmer
    return fibo_nubmer % 1234567






print(solution(3))
print(solution(5))