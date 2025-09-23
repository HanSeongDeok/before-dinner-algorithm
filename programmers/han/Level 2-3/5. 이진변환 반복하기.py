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

print(solution("110010101001"))