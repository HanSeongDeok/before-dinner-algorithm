import math
## *** 너무 좋은 문제 *** 
## 진짜 너무 좋은 문제!!! -> 계속 복습하기
def solution(n, k):
    conver_k = conver_k_number(n, k)
    numbers = conver_k.split("0")
    return sum([1 for i in numbers if i and is_prime(int(i))])

def conver_k_number(n: int, k: int) -> str:
    r = ''
    while(k <= n):
        r += str(n % k)
        n //= k
    return str(n) + r[::-1]

def is_prime(n: int) -> bool:
    if n <= 1: 
        return False
    for i in range(2, int(math.sqrt(n)) + 1):
        if n % i == 0:
            return False 
    return True

# 소수 찾기 -> 아리스토텔레스의 체
# TODO 복습 하기

print(solution(437674, 3))
print(solution(110011, 10))