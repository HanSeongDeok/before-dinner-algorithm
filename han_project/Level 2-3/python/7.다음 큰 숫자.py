# 완전 탐색(브루트포스)
# @ Day 1
def solution(n):
    cnt = custom_bin(n).count('1')
    up_number = n + 1
    while up_number <= 1000000:
        if cnt == custom_bin(up_number).count('1'):
            break
        up_number += 1
    return up_number

def custom_bin(n):
    number_bin = 0
    cnt = 1
    while n > 0:
        number_bin += n % 2 * cnt
        cnt *= 10
        n //= 2
    return str(number_bin) 


# @ Day2
def solution(n):
    number = bin(n)[2:].count('1')
    for i in range(n + 1, 1000001):
        if bin(i)[2:].count('1') == number:
            return i


# @ Day3 
def solution(n):
    compare_number = bin(n)[2:].count('1')
    for i in range(n+1, 1000000):
        one_counter = bin(i)[2:].count('1')
        if compare_number == one_counter:
            return i
    return -1





def custom_bin(n):
    bin_n = 0
    cnt = 1
    while n:
        bin_n += n % 2 * cnt
        cnt *= 10
        n //= 2
    return bin_n


print(custom_bin(10))

    return str(bin_n)
print(custom_bin(10))


def solution(n):
    result = n
    len_one = bin(n)[2:].count('1')
    for i in range(n+1, 1000001):
        if len_one == bin(i)[2:].count('1'):
            result = i
            return result
    return result




print(solution(78))
print(solution(15))