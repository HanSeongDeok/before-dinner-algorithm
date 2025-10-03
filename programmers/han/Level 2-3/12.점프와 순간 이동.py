# @ Day 1
# 탐욕적 기법 + 이진수 활용
def solution(n):
    count = 0
    while n:
        if n % 2 == 0:
            n //= 2
        else:
            n -= 1
            count += 1
    return count

# @ Day 2
def solution(n):
    count = 0
    while n:
        if n % 2 == 0:
            n //= 2
        else:
            n -= 1
            count+=1
    return count

def solution(n):
    result = 0
    while n:
        if n % 2 == 0:
            n //= 2
        else:
            result += 1
            n -= 1
    return result











print(solution(5))
print(solution(6))
print(solution(5000))
