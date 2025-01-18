def solution(n, k):
    answer = -1
    return int(conver_k_number(10, 3))

def conver_k_number(n, k):
    r = ''
    while(k <= n):
        n //= k
        r += str(n % k)
    return str(n) + r

print(solution(10, 3))