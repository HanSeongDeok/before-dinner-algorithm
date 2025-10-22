from math import sqrt

def solution(n, k):
    # 1. n을 k진수로 변환
    def to_k_base(n, k):
        s = ''
        while n > 0:
            s = str(n % k) + s
            n //= k
        return s

    # 2. 0을 기준으로 split하여 후보 소수 추출
    k_base = to_k_base(n, k)
    candidates = [x for x in k_base.split('0') if x]

    # 3. 소수 판별 함수
    def is_prime(num_str):
        num = int(num_str)
        if num < 2:
            return False
        if num == 2:
            return True
        if num % 2 == 0:
            return False
        for i in range(3, int(num**0.5) + 1, 2):
            if num % i == 0:
                return False
        return True

    # 4. 소수 개수 세기
    count = 0
    for cand in candidates:
        if is_prime(cand):
            count += 1
    return count


# @Day1 
def solution(n, k):
    def create_k(n, k):
        k_str = ''
        while n:
            k_str = str(n % k) + k_str
            n //= k
        return k_str
    
    k_n = create_k(n, k)
    zero_splits = k_n.split('0')

    def isPrime(num):
        if num < 2:
            return False
        if num == 2:
            return True
        for i in range(2, int(sqrt(num))+1):
            if num % i == 0:
                return False
        return True

    result = 0
    for n in zero_splits:
        if n and isPrime(int(n)):
            result += 1
    return result 




# @ Day 2
from math import sqrt
def solution(n, k):
    def convert_k_n(n, k):
        k_n_str = ''
        while n:
            k_n_str = str(n % k) + k_n_str
            n //= k
        return k_n_str
    
    k_n_arr = convert_k_n(n, k).split('0')
    result = 0

    def isPrimeCheck(n):
        if n < 2:
            return False
        for i in range(2, int(sqrt(n))+1):
            if n % 2 == 0:
                return False
        return True 

    for n in k_n_arr:
        if n and isPrimeCheck(int(n)):
            result += 1
    return result



print(solution(437674, 3))    # Expected output: 3
print(solution(110011, 10))   # Expected output: 2



def create_bin(n):
    bin_n = 0
    tmp = 1
    while n:
        bin_n += n % 2 * tmp
        tmp *= 10
        n //= 2
    return bin_n

def create_k(n, k):
    k_n = 0
    tmp = 1
    while n:
       k_n += n % k * tmp
       tmp *= 10
       n //= k
    return k_n 

def create_k_str(n, k):
    k_s = ''
    while n:
        k_s = str(n % k) + k_s
        n //= k
    return k_s

print(create_bin(4))
print(create_k(4, 4))
print(create_k_str(4, 4))
