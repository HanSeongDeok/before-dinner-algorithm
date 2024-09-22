# 다시 한번 생각해서 풀어보기.
def solution(n):
    count = 1
    while n > 1:
        if n % 2 == 0:
            n //= 2
        else:
            n -= 1
            count += 1 
    return count

# 오답 복습 x1
def solution(n):
    count = 1
    while n > 1:
        if (n % 2 == 0):
            n /= 2
        else:
            n -= 1
            count += 1
    return count

print(solution(5000))