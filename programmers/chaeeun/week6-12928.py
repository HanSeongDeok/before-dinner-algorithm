import math

def solution(n):
    answer = 0
    num = int(math.sqrt(n))
    for i in range(1, num + 1):
        if(n % i == 0):
            answer += i + int(n / i)
    
    if(num ** 2 == n) :
        answer -= num
    return answer
