import math
# @ Day 1
def solution(s):
    count = 0
    zero_count = 0

    while s != '1':
       zero_count += s.count('0')
       s = s.replace('0','')
       s = custom_bin(len(s))
    #    s = bin(len(s))[2:]
       count += 1
    return [count, zero_count]

def custom_bin(n):
    num = int(n)
    bin_num = 0
    cnt = 1
    while num:
        bin_num += int(num % 2) * cnt
        cnt *= 10
        num //= 2
    return str(bin_num)


# @ Day 2
def solution(s):
    count = 0
    zero_count = 0
    while s != '1':
        for c in s:
            if c == '0':
                zero_count += 1 
        s = custom_bin(len(s.replace('0', '')))
        count += 1
    return [count, zero_count]
        
def custom_bin(n):
    number_bin = 0
    cnt = 1
    while n > 0:
        number_bin += n % 2 * cnt
        cnt *= 10
        n //= 2
    return  str(number_bin)


def solution(s):
    zero_count = 0
    count = 0
    while s != '1':
        zero_count += s.count('0')
        s = s.replace('0','')
        # s = bin(len(s))[2:]
        s = custom_bin(len(s))
        count += 1
    return [count, zero_count]

# def custom_bin(n):
#     number_bin = 0
#     cnt = 1
#     while n > 0:
#         number_bin += n % 2 * cnt
#         cnt *= 10
#         n //= 2
#     return str(number_bin)

def custom_bin(n):
    cnt = 1
    bin_n = 0
    while n:
        bin_n += n % 2 * cnt
        n //= 2
        cnt *= 10
    return str(bin_n)

print(custom_bin(10))


def solution(n):
    zero_cnt = 0
    cnt = 0
    while n != '1' :
        zero_cnt += n.count('0')
        n = n.replace('0','')
        n = bin(len(n))[2:]
        cnt += 1
    return [cnt, zero_cnt]


print(solution("110010101001"))