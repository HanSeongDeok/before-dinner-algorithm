import math
def solution(n: int, m: int) -> list:
    print(math.gcd(n,m))
    return [math_gcd(n, m), 
            int((n*m) / math_gcd(n, m))]

def custom_gcd(n, m):
    target = m if (n > m) else n
    cnt, gcd = 1, 1
    while(pow(cnt, 2) <= n * m or cnt <= target):
        if divmod(n * m, cnt)[1] == 0 and\
           divmod(n, cnt)[1] == 0 and\
           divmod(m, cnt)[1] == 0 :
               gcd = cnt
        cnt += 1
    return gcd

def math_gcd(n, m):
    return math.gcd(n, m)

print(solution(3, 12))
print(solution(2, 5))